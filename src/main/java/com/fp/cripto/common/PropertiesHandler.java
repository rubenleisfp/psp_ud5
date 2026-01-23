package com.fp.cripto.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * Clase para manejar las propiedades de la aplicación.
 */
public class PropertiesHandler {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream inputStream = PropertiesHandler.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            // Manejar la excepción aquí o propagarla
            throw new RuntimeException("Error loading properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}