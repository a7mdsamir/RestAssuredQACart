package com.qacart;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;

public class TC03ResponseExtract {

    @Test
    public void test(){

        String name = given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
                .when().get("users")
                .then().extract().response().path("[0].name") ;


        System.out.println(name); // print name of 1st item


    }

}
