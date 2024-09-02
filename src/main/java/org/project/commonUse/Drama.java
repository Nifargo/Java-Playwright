package org.project.commonUse;

import com.microsoft.playwright.Locator;
import org.project.commonUse.enviromentManager.EnvironmentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.project.commonUse.WaitUtils.waitForElement;

public class Drama {

    private static final Logger logger = LoggerFactory.getLogger(Drama.class);


    public static void open(String url) {
        String baseUrl = EnvironmentConfig.getBaseUrl();
        var targetUrl = url.startsWith("http") ? url : baseUrl+ url;
        logger.info("Navigating to URL: {}", targetUrl);
        Scene.play().getPage().navigate(targetUrl);
    }

    public static LocatorActions find(String selector) {
        logger.debug("Finding element with selector: {}", selector);
        waitForElement(selector);
        return new LocatorActions(Scene.play().getPage().locator(selector).first());
    }

    public static LocatorActions find(String selector, String filterWithText) {
        return new LocatorActions(Scene.play().getPage().locator(selector).filter(
                new Locator.FilterOptions().setHasText(filterWithText)
        ).first());
    }

    public static LocatorActions $(String selector) {
        waitForElement(selector);
        return find(selector);
    }

    public static LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public LocatorActions f(String selector) {
        return find(selector);
    }

    public void clearCookies() {
        Scene.play().getContext().clearCookies();
    }

    public Drama newTab() {
        Scene.play().getContext().newPage();
        return this;
    }

    public void closeCurrentTab() {
        Scene.play().getPage().close();
    }

    public void switchToTab(int index) {
        var pages = Scene.play().getContext().pages();
        if (index >= 0 && index < pages.size()) {
            Scene.play().setPage(pages.get(index));
        }
    }

    public String getCurrentUrl() {
        return Scene.play().getPage().url();
    }
}
