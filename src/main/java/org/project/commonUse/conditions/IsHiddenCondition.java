package org.project.commonUse.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import org.project.commonUse.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.project.commonUse.PlayItRight.ConfigManager.config;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isHidden(
                new LocatorAssertions.IsHiddenOptions().setTimeout(config().defaultTimeout())
        );
    }

}
