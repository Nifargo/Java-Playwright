package org.project.commonUse.testRunners;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.project.commonUse.Configuration;
import org.project.commonUse.Scene;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DramaExtension implements BeforeEachCallback, AfterEachCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        String env = System.getProperty("env", "preprod");
        System.setProperty("env", env);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        Scene.initTestContext(Configuration.saveTraces, getTestName(context));
        Allure.getLifecycle().startTestCase(context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        Scene.closeContext(Configuration.saveTraces, getTestName(context));
    }

    private String getTestName(ExtensionContext context) {
        return context.getRequiredTestClass().getName() + " " + context.getDisplayName();
    }
}
