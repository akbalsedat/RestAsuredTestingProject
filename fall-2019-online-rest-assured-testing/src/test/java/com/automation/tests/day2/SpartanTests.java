package com.automation.tests.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanTests {

    String BASE_URL = "http://3.85.41.58:8000";
    @Test
    @DisplayName("Get list of all spartans") // optional
    public void getAllSpartans(){
        // 401 unauthorized
        // how to provide credentials
        // different type of oauth 2.0, basic, etc.
        given().
                auth().basic("admin", "admin"). // authorization lines...
                baseUri(BASE_URL).
        when().
                get("/api/spartans").prettyPeek().
        then().statusCode(200);
    }


}
