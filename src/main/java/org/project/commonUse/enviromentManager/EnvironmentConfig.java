package org.project.commonUse.enviromentManager;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentConfig.class);
    @Getter
    private static String baseUrl;
    private static Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "preprod");
        logger.info("Loading environment properties for: {}", env);
        System.out.println("Environment: " + env);
        try (InputStream input = EnvironmentConfig.class.getClassLoader().getResourceAsStream("environments.properties")) {
            if (input == null) {
                logger.error("Unable to find environments.properties");
                throw new RuntimeException("Unable to find environments.properties");
            }
            properties.load(input);
            baseUrl = properties.getProperty(env + ".baseUrl");
            if (baseUrl == null) {
                logger.error("Base URL for environment {} is not defined", env);
                throw new RuntimeException("Base URL for environment " + env + " is not defined");
            }
            logger.info("Properties loaded successfully for: {}", env);
        } catch (IOException ex) {
            logger.error("Error loading environment properties", ex);
            throw new RuntimeException("Error loading environment properties", ex);
        }
    }
}