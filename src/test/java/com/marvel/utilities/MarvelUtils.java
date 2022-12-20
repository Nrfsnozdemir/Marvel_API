package com.marvel.utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MarvelUtils {

    private static String ts;
    private static String apiKey;
    private static String hash;

    public static String authentication() {
        ts = ConfigurationReader.getProperty("ts");
        apiKey = ConfigurationReader.getProperty("apiKey");
        hash = ConfigurationReader.getProperty("hash");
        String authentication = "?ts=" + ts + "&apikey=" + apiKey + "&hash=" + hash;
        return authentication;
    }
}
