package com.marvel.task;

import com.marvel.utilities.MarvelTestBase;
import com.marvel.utilities.MarvelUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetCharacters extends MarvelTestBase {

    @Test
    public void test(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/characters?" + MarvelUtils.authentication());

        response.prettyPrint();


    }
}
