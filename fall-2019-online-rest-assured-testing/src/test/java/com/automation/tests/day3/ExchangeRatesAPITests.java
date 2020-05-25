package com.automation.tests.day3;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ExchangeRatesAPITests {
    @BeforeAll
    public static  void setup(){
        // for every single request this is a baseUri
        baseURI = "http://api.openrates.io";
    }

    // get latest currency rates
    @Test
    public void getLatestRates(){
        Response response =
                given().
                        queryParam("base", "USD").
                when().
                        get("/latest").prettyPeek();

        Headers headers = response.getHeaders(); // all headers
        System.out.println("content type: " + headers.getValue("Content-Type"));

        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("base", is("USD"));
        response.then().assertThat().body("date", containsString("2020-05-22"));
        // is same as equals
    }

    //get history of rates for 2008
    @Test
    public void getHistoryOfRates() {
        Response response = given().
                queryParam("base", "USD").
                when().
                get("/2008-01-02").prettyPeek();
        Headers headers = response.getHeaders();//response header

        response.then().assertThat().
                statusCode(200).
                and().
                body("date", is("2008-01-02")).
                and().
                body("rates.USD", is(1.0f));
        //and() doesn't have a functional role, it's just a syntax sugar
        //we can chain validations
        //how we can retrieve

        //rates - it's an object
        //all currencies are like instance variables
        //to get any instance variable (property), objectName.propertyName
        float actual = response.jsonPath().get("rates.USD");

        assertEquals(1.0, actual);



        /**
         *  Get a JsonPath view of the response body. This will let you use the JsonPath syntax to get values from the response.
         *      * Example:
         *      * <p>
         *      * Assume that the GET request (to <tt>http://localhost:8080/lotto</tt>) returns JSON as:
         *      * <pre>
         *      * {
         *      * "lotto":{
         *      *   "lottoId":5,
         *      *   "winning-numbers":[2,45,34,23,7,5,3],
         *      *   "winners":[{
         *      *     "winnerId":23,
         *      *     "numbers":[2,45,34,23,3,5]
         *      *   },{
         *      *     "winnerId":54,
         *      *     "numbers":[52,3,12,11,18,22]
         *      *   }]
         *      *  }
         *      * }
         *      * </pre>
         *      * </p>
         *      * You can the make the request and get the winner id's by using JsonPath:
         *      * <pre>
         *      * List<Integer> winnerIds = get("/lotto").jsonPath().getList("lotto.winnders.winnerId");
         *      * </pre>
         *
         */

        System.out.println(actual);
    }
}
