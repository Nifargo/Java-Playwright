package org.project.commonUse.enviromentManager;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
@Slf4j
public class EnvironmentConfig {


    private static final Properties properties = new Properties();
    @Getter
    private static String baseUrl;

    static {
        String env = System.getProperty("env", "preprod");
        log.info("Loading environment properties for: {}", env);
        try (InputStream input = EnvironmentConfig.class.getClassLoader().getResourceAsStream("environments.properties")) {
            if(input == null) {
                throw new RuntimeException("Unable to find environments.properties");
            }
            properties.load(input);
            baseUrl = properties.getProperty(env + ".baseUrl");
            if(baseUrl == null) {
                throw new RuntimeException("Base URL for environment " + env + " is not defined");
            }
            log.info("Properties loaded successfully for: {}", env);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading environment properties", ex);
        }
    }
}