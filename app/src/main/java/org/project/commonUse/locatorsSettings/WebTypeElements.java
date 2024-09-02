package org.project.commonUse.locatorsSettings;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WebTypeElements {

    A("a"),
    SPAN("span"),
    TEXTAREA("textarea"),
    BUTTON("button"),
    INPUT("input"),
    APPBUTTON("app-button"),
    APPLISTBOX("app-list-box"),
    APPCHECKBOX("app-checkbox"),
    APPVALIDATION("app-validation-warning"),
    APPRANGESLIDER("app-range-slider"),
    APPTIMESLIDER("app-time-slider"),
    DKVTOGGLE("dkv-toggle"),
    DKVCHECKBOX("dkv-checkbox"),
    DKVBUTTON("dkv-button");

    public final String type;
}
