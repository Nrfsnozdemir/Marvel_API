package com.marvel.task;

import com.marvel.utilities.MarvelTestBase;
import com.marvel.utilities.MarvelUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetCharacters extends MarvelTestBase {

    @Test
    public void test() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/characters" + MarvelUtils.authentication());

        //Map<String, Object> jsonMap = response.body().as(Map.class);
        List<String> expectedProperties = Arrays.asList("id", "name", "description", "modified", "resourceURI",
                "thumbnail", "comics", "stories", "events", "urls");
        List<Map<String, Object>> path = response.path("data.results");
        for (Map<String, Object> each : path) {
            for (int i = 0; i < expectedProperties.size(); i++) {
                assertThat(expectedProperties.get(i), each.containsKey(i));
            }

        }


    }
}
