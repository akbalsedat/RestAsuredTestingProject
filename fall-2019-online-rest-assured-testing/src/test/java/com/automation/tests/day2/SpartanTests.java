package com.automation.tests.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        // instead of string variable, we can use external JSON file
        // use File class to read JSON and pass it into body
        // provide path to the JSON as a parameter
        File jsonFile = new File(System.getProperty("user.dir") + "/spartan.json");
        given().
                contentType(ContentType.JSON).
                auth().basic("admin", "admin"). // authorization lines...
                body(jsonFile).
                baseUri(BASE_URL).
        when().
                post("/api/spartans").prettyPeek().
        then().statusCode(201);
    }

    // delete a spartan
    @Test
    @DisplayName("delete a spartan to the list") // optional
    public void deleteSpartan(){
        // {id} parameter

        given().
                contentType(ContentType.JSON).
                auth().basic("admin", "admin"). // authorization lines...
                baseUri(BASE_URL).
        when().
                delete("/api/spartans/{id}", 380).prettyPeek().
        then().
                statusCode(204);
    }

}
