package org.project.commonUse.testRunners;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.project.commonUse.PlayItRight.PlayIt;

import static org.project.commonUse.PlayItRight.ConfigManager.config;

public class PlayExtensions implements BeforeEachCallback, AfterEachCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        String env = System.getProperty("env", "preprod");
        System.setProperty("env", env);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        PlayIt.initTestContext(config().saveTraces(), getTestName(context));
        Allure.getLifecycle().startTestCase(context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        PlayIt.closeContext(config().saveTraces(), getTestName(context));
    }

    private String getTestName(ExtensionContext context) {
        return context.getRequiredTestClass().getName() + " " + context.getDisplayName();
    }
}
