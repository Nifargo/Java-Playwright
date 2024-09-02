package org.project.commonUse;

import com.microsoft.playwright.Locator;
import lombok.Data;
import org.project.commonUse.conditions.Condition;

@Data
public class LocatorActions {

    private final Locator locator;

    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    public LocatorActions click() {
        locator.click();
        return this;
    }

    public LocatorActions shouldBe(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions getText() {
        locator.textContent();
        return this;
    }

    public LocatorActions should(Condition condition) {
        condition.verify(this);
        return this;
    }


    public boolean isVisible(){
        return locator.isVisible();
    }

    public LocatorActions shouldHave(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions shouldHas(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions hover() {
        locator.hover();
        return this;
    }

    public LocatorActions doubleClick() {
        locator.dblclick();
        return this;
    }

    public LocatorActions check() {
        locator.check();
        return this;
    }
}
