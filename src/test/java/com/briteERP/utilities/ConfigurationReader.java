package com.briteERP.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;

    static {
        String path = "configuration.properties";
        try {
            //path to our .properties file
            FileInputStream input = new FileInputStream(path);
            //we creat object of input stream to access file
            configFile = new Properties();
            //initialize configFile
            configFile.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String key){
        return configFile.getProperty(key);


    }
}

