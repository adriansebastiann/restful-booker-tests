package com.restfulbooker.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "local");
        String resourceName = "config/" + env + ".properties";
        try (InputStream is = Configuration.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (is == null) {
                throw new RuntimeException("Config file not found: " + resourceName);
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String getBaseUri() { return props.getProperty("base.uri"); }
    public static String getAuthPath() { return props.getProperty("auth.path"); }
    public static String getBookingPath() { return props.getProperty("booking.path"); }
    public static String getPingPath() { return props.getProperty("ping.path"); }
}