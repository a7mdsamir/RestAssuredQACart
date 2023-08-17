package com.qacart;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC05ResponseLogging {

    @Test
    public void test(){


        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
                .when().get("users")
                .then().log().ifError() ;
// log for response in case error

        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
                .when().get("users")
                .then().log().ifValidationFails()
                .body( "[0].name" , equalTo("Tamara Bartell")) ;
// log for response in case Validation Fails

        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1").log().ifValidationFails()
                .when().get("users")
                .then().log().ifValidationFails()
                .body( "[0].name" , equalTo("Tamara Bartell")) ;
// log for request and response in case Validation Fails

    }

}
