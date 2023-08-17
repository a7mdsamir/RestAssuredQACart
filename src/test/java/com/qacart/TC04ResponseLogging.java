package com.qacart;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;

public class TC04ResponseLogging {

    @Test
    public void test(){


        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1").log().all()
                .when().get("users")
                .then() ;
// log for request (all)

        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1").log().method()
                .when().get("users")
                .then() ;
// log for request (method)

        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all() ;
// log for response

        given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
                .when().get("users")
                .then().log().status() ;
// log for status

    }

}
