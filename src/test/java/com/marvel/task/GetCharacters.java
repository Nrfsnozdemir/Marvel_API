package com.marvel.task;

import com.marvel.utilities.MarvelTestBase;
import com.marvel.utilities.MarvelUtils;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetCharacters extends MarvelTestBase {

    Response response;
    List<String> expectedProperties;
    List<Map<String, Object>> actualProperties;

    @DisplayName("Every possible character record has all JSON properties as expected")
    @Test
    public void test1() {
        response = given().accept(ContentType.JSON)
                .when()
                .get("/characters" + MarvelUtils.authentication());

        expectedProperties = Arrays.asList("id", "name", "description", "modified", "thumbnail", "resourceURI",
                "comics", "stories", "events", "urls");
        JsonPath jsonPath = response.jsonPath();
        actualProperties = jsonPath.getList("data.results");
        for (Map<String, Object> each : actualProperties) {
            assertTrue(each.keySet().containsAll(expectedProperties));
        }
    }
}
