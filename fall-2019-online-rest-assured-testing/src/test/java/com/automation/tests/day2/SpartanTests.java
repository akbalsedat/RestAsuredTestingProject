package com.automation.tests.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

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
// add a new spartan
    @Test
    @DisplayName("add a new spartan to the list") // optional
    public void addSpartan(){
        String body = "{\"gender\": \"Male\", \"name\": \"Random User\", \"phone\": 9999999999}";

        given().
                contentType(ContentType.JSON).
                auth().basic("admin", "admin"). // authorization lines...
                body(body).
                baseUri(BASE_URL).
        when().
                post("/api/spartans").prettyPeek().
        then().statusCode(201);
    }

}
