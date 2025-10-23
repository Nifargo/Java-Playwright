package org.project.commonUse.PlayItRight;

import com.google.common.collect.ImmutableMap;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import io.qameta.allure.Attachment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.project.commonUse.PlayItRight.BrowserFactoryRoom.BrowserManager;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static org.project.commonUse.PlayItRight.ConfigManager.config;

@Getter
@Setter
@AllArgsConstructor
public class PlayIt {

    private static final ConcurrentHashMap<Long, PlayIt> play = new ConcurrentHashMap<>();

    private BrowserContext context;

    private Page page;

    private Playwright playwright;

    private Browser browser;

    private PlayIt(Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    static PlayIt initBrowser() {
        return play.computeIfAbsent(Thread.currentThread().getId(), k -> {
            var playwright = Playwright.create();
            var browser = BrowserManager.getBrowser(playwright);

            allureEnvironmentWriter(
                    ImmutableMap.<String, String>builder()
                            .put("Platform", System.getProperty("os.name"))
                            .put("Version", System.getProperty("os.version"))
                            .put("Browser", config().browser().toUpperCase())
                            .put("Context URL", config().baseUrl())
                            .build(),
                    config().allureResultsDir() + "/");

            return new PlayIt(playwright, browser);
        });
    }

    public static void initTestContext(boolean traces, String testName) {
        var newContextOptions = new Browser.NewContextOptions();
        newContextOptions.baseURL = config().baseUrl();

        var scene = initBrowser();
        var browserContext = scene.getBrowser().newContext(newContextOptions);
        if (traces) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setTitle(testName)
                    .setName(testName + ".zip")
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
            );
        }
        var targetPage = browserContext.newPage();

        scene.setContext(browserContext);
        scene.setPage(targetPage);
    }

    @Attachment(value = "Test Video", type = "video/webm")
    @SneakyThrows
    public byte[] captureVideo() {
        return Files.readAllBytes(page.video().path());
    }

    @Attachment(value = "Failed Test Case Screenshot", type = "image/png")
    private byte[] captureScreenshotOnFailure(){
        return page.screenshot();
    }

    public static void closeContext(boolean traces, String testName) {
        var scene = initBrowser();
        scene.getPage().close();
        var targetContext = scene.getContext();
        if (traces) {
            targetContext.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get(config().tracesPath(), testName + ".zip"))
            );
        }
        targetContext.close();
    }

    static void close() {
        var scene = play.remove(Thread.currentThread().getId());
        if (scene != null) {
            scene.getPage().close();
            scene.getContext().close();
            scene.getBrowser().close();
            scene.getPlaywright().close();
        }
    }
}
