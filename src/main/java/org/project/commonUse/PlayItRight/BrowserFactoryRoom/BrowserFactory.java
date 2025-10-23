package org.project.commonUse.PlayItRight.BrowserFactoryRoom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

import static org.project.commonUse.PlayItRight.ConfigManager.config;

public enum BrowserFactory {

    CHROMIUM {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.chromium().launch(options());
        }
    },
    FIREFOX {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.firefox().launch(options());
        }
    },
    WEBKIT {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.webkit().launch(options());
        }
    };

    public BrowserType.LaunchOptions options() {
        return new BrowserType.LaunchOptions()
                .setHeadless(config().headless())
                .setTimeout(config().browserToStartTimeout())
                .setDevtools(config().devTools())
                .setSlowMo(config().poolingInterval())
                .setTracesDir(Paths.get(config().tracesPath()));
    }

    public abstract Browser createInstance(final Playwright playwright);
}
