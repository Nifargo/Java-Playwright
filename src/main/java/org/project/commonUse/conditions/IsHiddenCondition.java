package org.project.commonUse.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import org.project.commonUse.Configuration;
import org.project.commonUse.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isHidden(
                new LocatorAssertions.IsHiddenOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}
