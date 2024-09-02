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
    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "preprod");
        logger.info("Loading environment properties for: {}", env);
        try (InputStream input = EnvironmentConfig.class.getClassLoader().getResourceAsStream("environments.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find environments.properties");
            }
            properties.load(input);
            baseUrl = properties.getProperty(env + ".baseUrl");
            if (baseUrl == null) {
                throw new RuntimeException("Base URL for environment " + env + " is not defined");
            }
            logger.info("Properties loaded successfully for: {}", env);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading environment properties", ex);
        }
    }
}