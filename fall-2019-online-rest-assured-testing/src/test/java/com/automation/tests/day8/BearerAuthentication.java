package com.automation.tests.day8;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BearerAuthentication {

    @BeforeAll
    public static void setup() {
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";
    }
    @Test
    public void loginTest(){
        Response response = given().
                queryParam("email", "teacherva5@gmail.com").
                queryParam("password", "maxpayne").
        when().
                get("/sign").prettyPeek();

        String token = response.jsonPath().getString("accessToken");
        System.out.println("token = " + token);
    }

    @Test
    @DisplayName("Negative test: attempt to retrieve list of rooms without authentication token")
    public void getRoomsTest(){
        // swe suppose to get 401 unauthorized access status code. However,
        // we received 422 Unprocessable Entity
                get("/api/rooms").prettyPeek().then().statusCode(401);
    }

    @Test
    public void getRoomsTest2(){
        // 1. Request: to get a token.
        Response response = given().
                queryParam("email", "teacherva5@gmail.com").
                queryParam("password", "maxpayne").
                when().
                get("/sign").prettyPeek();

        String token = response.jsonPath().getString("accessToken");

        Response response2 = given().
                                    auth().oauth2(token).
                             when().
                                    get("/api/rooms").prettyPeek();
    }

    public String getToken(){
        Response response = given().
                queryParam("email", "teacherva5@gmail.com").
                queryParam("password", "maxpayne").
                when().
                get("/sign").prettyPeek();
        response.then().log().ifError();

        String token = response.jsonPath().getString("accessToken");
        System.out.println("token = " + token);
        return token;
    }

    public String getToken(String email, String password){
        Response response = given().
                queryParam("email", email).
                queryParam("password", password).
                when().
                get("/sign").prettyPeek();
        response.then().log().ifError();

        String token = response.jsonPath().getString("accessToken");
        System.out.println("token = " + token);
        return token;
    }
}
