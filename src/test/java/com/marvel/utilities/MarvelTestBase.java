package com.marvel.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class MarvelTestBase {

    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("marvelBaseURI");
    }
}
