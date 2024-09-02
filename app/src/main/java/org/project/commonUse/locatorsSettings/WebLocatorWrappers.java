package org.project.commonUse.locatorsSettings;

public class WebLocatorWrappers {

    public static final String DATA_TEST_ID = "@data-test-id=";

    public static String getLocatorByType(WebTypeElements type, String id) {
        return "//" + type.getType() + "[" + DATA_TEST_ID + "'" + id + "']";
    }

    public static final String ID = "@id=";

    public static String getLocatorByTypeID(WebTypeElements type, String id) {
        return "//" + type.getType() + "[" + ID + "'" + id + "']";
    }

}
