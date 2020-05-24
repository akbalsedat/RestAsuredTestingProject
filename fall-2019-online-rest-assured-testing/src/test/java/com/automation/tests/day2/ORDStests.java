package com.automation.tests.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ORDStests {

    String BASE_URL = "http://3.85.41.58:1000/ords/hr";

    @Test
    @DisplayName("Get list of all employees")
    public void getAllEmployees(){
     Response response = given().
                baseUri(BASE_URL).
             when().
                get("/regions").prettyPeek();
    }

    @Test
    @DisplayName("Get employee under specific ID")
    public void getOneEmployee(){
        Response response = given().
                baseUri(BASE_URL).
                when().
                get("/employees/{id}", 100).prettyPeek();

        response.then().statusCode(200); // to verify that status code is 200

    }

    @Test
    @DisplayName("Get list of all countries and verify status code is 200")
    public void getAllCountries(){
            given().
                baseUri(BASE_URL).
            when().
                get("/countries").prettyPeek().then().statusCode(200);
    }
}
