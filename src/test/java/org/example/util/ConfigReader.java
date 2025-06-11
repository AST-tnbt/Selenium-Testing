package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    
    static {
        loadConfig();
    }
    
    private static void loadConfig() {
        properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }
    
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties file");
        }
        return value;
    }
    
    public static String getValidUsername() {
        return getProperty("VALID_USERNAME");
    }
    
    public static String getValidPassword() {
        return getProperty("VALID_PASSWORD");
    }
    
    public static String getBaseUrl() {
        return getProperty("BASE_URL");
    }
    
    public static String getBrowser() {
        return getProperty("BROWSER");
    }
    
    public static String getDriverPath() {
        return getProperty("DRIVER_PATH");
    }
    
    public static String getString255() {
        return getProperty("STRING_255");
    }
    
    public static String getString256() {
        return getProperty("STRING_256");
    }
} 