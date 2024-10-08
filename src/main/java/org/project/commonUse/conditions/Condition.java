package org.project.commonUse.conditions;


import org.project.commonUse.LocatorActions;

public interface Condition {

    Condition visible = new VisibleCondition();
    Condition hidden = new IsHiddenCondition();

    static Condition text(String expectedText) {
        return new TextCondition(expectedText);
    }

    void verify(LocatorActions locatorActions);

}
