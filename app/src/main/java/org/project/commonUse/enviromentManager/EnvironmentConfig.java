package org.project.commonUse.enviromentManager;

public class EnvironmentConfig {
    private static final String DEFAULT_ENV = "preprod";
    private static final String PREPROD_URL = "https://my-preprod.dkv-mobility.com";
    private static final String DEV_URL = "https://my-dev.dkv-mobility.com";
    private static final String PROD_URL = "https://my.dkv-mobility.com";

    public static String getBaseUrl() {
        String environment = System.getProperty("env", DEFAULT_ENV);
        return switch (environment.toLowerCase()) {
            case "preprod" -> PREPROD_URL;
            case "dev" -> DEV_URL;
            case "prod" -> PROD_URL;
            default -> throw new IllegalArgumentException("Unknown environment: " + environment);
        };
    }
}