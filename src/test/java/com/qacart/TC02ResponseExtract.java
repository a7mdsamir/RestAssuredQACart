package com.qacart;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;

public class TC02ResponseExtract {

    @Test
    public void test(){

            Response res = given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
            .when().get("users")
            .then().extract().response() ;

             System.out.println(res.asString()); // print all response

        String name = res.path("[0].name");
        System.out.println(name); // print name of 1st item

        String namee = JsonPath.from(res.asString()).getString("[0].name") ;
        System.out.println(namee); // print name of 1st item


    }

}
