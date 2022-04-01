package com.java.senla.model.properti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static final String FILE_NAME = "resource/config.properties";
    private static Properties properties = new Properties();
    private static InputStream inputStream;
    private static Settings settings;

    public Settings() {
        initialize();
    }

    public static Settings getSettings() {
        if (settings == null) {
            settings = new Settings();
        }
        return settings;
    }

    private void initialize() {
        try {
            inputStream = new FileInputStream(FILE_NAME);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
