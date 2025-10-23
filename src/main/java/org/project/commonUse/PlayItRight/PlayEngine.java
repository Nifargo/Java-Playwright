package org.project.commonUse.PlayItRight;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.project.commonUse.LocatorActions;
import org.project.commonUse.enviromentManager.EnvironmentConfig;

import static org.project.commonUse.PlayItRight.WaitTools.waitForElement;

@Slf4j
public class PlayEngine {

    public static void open(String url) {
        String baseUrl = EnvironmentConfig.getBaseUrl();
        var targetUrl = url.startsWith("http") ? url : baseUrl + url;
        log.info("Navigating to URL: {}", targetUrl);
        PlayIt.initBrowser().getPage().navigate(targetUrl);
    }

    public static LocatorActions find(String selector) {
        log.debug("Finding element with selector: {}", selector);
        waitForElement(selector);
        return new LocatorActions(PlayIt.initBrowser().getPage().locator(selector).first());
    }

    public static LocatorActions find(String selector, String filterWithText) {
        return new LocatorActions(PlayIt.initBrowser().getPage().locator(selector).filter(
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
        PlayIt.initBrowser().getContext().clearCookies();
    }

    public PlayEngine newTab() {
        PlayIt.initBrowser().getContext().newPage();
        return this;
    }

    public void closeCurrentTab() {
        PlayIt.initBrowser().getPage().close();
    }

    public void switchToTab(int index) {
        var pages = PlayIt.initBrowser().getContext().pages();
        if (index >= 0 && index < pages.size()) {
            PlayIt.initBrowser().setPage(pages.get(index));
        }
    }

    public String getCurrentUrl() {
        return PlayIt.initBrowser().getPage().url();
    }
}
