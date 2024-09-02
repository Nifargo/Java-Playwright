package org.project.commonUse;

public class Configuration {


    public static String baseUrl = null; // This will be null by default
    public static boolean headless = false;
    public static boolean devTools = false;
    public static double defaultTimeout = 4000.0;
    public static double poolingInterval = 100.0;

    public static double browserToStartTimeout = 30000.0;

    public static boolean saveTraces = true;

    public static String tracesPath = System.getProperty("user.dir") + "/build/pw";
}
