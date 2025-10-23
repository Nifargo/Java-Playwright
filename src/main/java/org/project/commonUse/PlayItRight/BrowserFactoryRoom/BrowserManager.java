package org.project.commonUse.PlayItRight.BrowserFactoryRoom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import lombok.experimental.UtilityClass;

import static org.project.commonUse.PlayItRight.ConfigManager.config;

@UtilityClass
public class BrowserManager {

    public static Browser getBrowser(final Playwright playwright) {
        String browser = config().browser();
        System.out.println("Browser to be used: " + browser); // Перевірка
        return BrowserFactory.valueOf(browser.toUpperCase()).createInstance(playwright);
    }
}
