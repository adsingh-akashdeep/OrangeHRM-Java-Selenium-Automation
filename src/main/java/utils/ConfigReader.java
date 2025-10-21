package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    protected static Properties properties;

    public static void loadProperties() {
        properties = new Properties();
        try {
            FileReader input = new FileReader("src/main/resources/Config.Properties");
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading config: " + e.getMessage());
        }
    }
    public static String getProperty(String key){
        if(properties == null){
            loadProperties(); // load only if not already loaded
        }
        return properties.getProperty(key);
    }
    public static long getLongProperty(String key){
        return Long.parseLong(properties.getProperty(key));
    }
}
