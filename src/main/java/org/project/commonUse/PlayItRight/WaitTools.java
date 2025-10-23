package org.project.commonUse.PlayItRight;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import lombok.experimental.UtilityClass;

import static ch.qos.logback.core.spi.ComponentTracker.DEFAULT_TIMEOUT;

@UtilityClass
public class WaitTools {

    public static Locator waitForElement(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Locator cannot be null");
        }
        Locator locator = PlayIt.initBrowser().getPage().locator(selector);
        try {
            locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(DEFAULT_TIMEOUT));
        } catch (TimeoutError e) {
            throw new RuntimeException("Element not visible after " + DEFAULT_TIMEOUT + " ms: " + selector, e);
        }
        return locator;
    }
}
