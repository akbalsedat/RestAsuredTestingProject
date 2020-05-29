package com.automation.tests.day9;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class BadSSL {
    @Test
    public void badSSLCertificateTest(){
        /**
         * no valid certificate, no handshake, no secure connection
         * relaxedHTTPSValidation() - tells us when we interact with a website with fake certificate
         */
        baseURI = "https://untrusted-root.badssl.com/";
        Response response = given().relaxedHTTPSValidation().get().prettyPeek();
        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("apple".matches("a-zA-Z"));

    }
}
