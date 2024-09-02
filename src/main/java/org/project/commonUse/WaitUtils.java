package org.project.commonUse;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitUtils {

    private static final double DEFAULT_TIMEOUT = 15000;

    public static Locator waitForElement(String selector) {
        if (selector == null) {
            throw new IllegalArgumentException("Locator cannot be null");
        }
        Locator locator = Scene.play().getPage().locator(selector);
        try {
            locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(DEFAULT_TIMEOUT));
        } catch (TimeoutError e) {
            throw new RuntimeException("Element not visible after " + DEFAULT_TIMEOUT + " ms: " + selector, e);
        }
        return locator;
    }
}
