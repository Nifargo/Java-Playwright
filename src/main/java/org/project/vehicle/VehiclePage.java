package org.project.vehicle;


import org.project.commonUse.conditions.Condition;

import static org.project.commonUse.Drama.$;
import static org.project.commonUse.locatorsSettings.WebLocatorWrappers.getLocatorByTypeID;
import static org.project.commonUse.locatorsSettings.WebTypeElements.BUTTON;

public class VehiclePage {

    String brand = getLocatorByTypeID(BUTTON, "headlessui-listbox-button-1");

    public void isVisibleBrandDD() {
        $(brand).shouldBe(Condition.visible);
    }

    public void has() {
        $(brand).getText();
    }

    public void clickBrandDD() {
        $(brand).click();
    }

    public boolean visibilityBrandField() {
        return $(brand).isVisible();
    }
}
