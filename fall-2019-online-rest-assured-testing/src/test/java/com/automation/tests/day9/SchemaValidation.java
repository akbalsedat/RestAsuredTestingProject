package com.automation.tests.day9;

import com.automation.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.*;

public class SchemaValidation {

    @BeforeAll
    public static void beforeAll() {
        baseURI = ConfigurationReader.getProperty("SPARTAN.URI");
        authentication = basic("admin", "admin");
    }

    @Test
    public void schemaValidationTest(){
        // get json schema and store it in file object
        File schema = new File("spartan_schema.json");
        get("/spartans/{id}", 35).prettyPeek().then().
                body(JsonSchemaValidator.matchesJsonSchema(schema));
    }

    @Test
    public void schemaValidationListTest(){
        File schemaFile = new File("spartan_schema.json");

        Response response = given().accept(ContentType.JSON).when().get("/spartans");
        List<Integer> id_collection = response.jsonPath().getList("id");

        for (int index = 0; index < id_collection.size(); index++) {
            get("/spartans/{id}", id_collection.get(index)).
                    then().
                            body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            System.out.println("Spartan with " + id_collection.get(index) + " id passed schema validation.");
        }
    }
}
