package org.project.commonUse.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import lombok.AllArgsConstructor;
import org.project.commonUse.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.project.commonUse.PlayItRight.ConfigManager.config;

@AllArgsConstructor
public class TextCondition implements Condition {

    private final String expectedText;

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).hasText(
                expectedText,
                new LocatorAssertions.HasTextOptions().setTimeout(config().defaultTimeout())
        );
    }

}
