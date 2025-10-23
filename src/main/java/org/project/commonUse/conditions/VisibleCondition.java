package org.project.commonUse.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import org.project.commonUse.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.project.commonUse.PlayItRight.ConfigManager.config;

public class VisibleCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(config().defaultTimeout())
        );
    }

}
