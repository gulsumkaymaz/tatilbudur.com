package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static Properties prop;

    public static String getProperty(String key){
        prop = new Properties();
        try {
            // src/test/resources/config/config.properties
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }

        String value = prop.getProperty(key);

        return value;

    }

    }

