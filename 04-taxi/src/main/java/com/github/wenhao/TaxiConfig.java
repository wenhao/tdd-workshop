package com.github.wenhao;

import java.io.IOException;
import java.util.Properties;

public class TaxiConfig
{
    private static final String TAXI_CONFIG = "/taxi.properties";

    public String get(String taxiType, String time, String key)
    {
        Properties properties = getConfig();
        return properties.getProperty(String.format("%s.%s.%s", taxiType, time, key));
    }

    private Properties getConfig()
    {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(TAXI_CONFIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
