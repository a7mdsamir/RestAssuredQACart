package com.qacart;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.contains;

public class TC01ResponseAssertion {

    @Test
    public void test(){

            given().baseUri("https://64d35fe467b2662bf3dc1b96.mockapi.io/api/v1")
           .when().get("users")
           .then()
                    .assertThat().statusCode(200)
                    .assertThat().body( "[0].name" , equalTo("Tamara Bartell")) //v zt name of 1st item is tamara
                    .assertThat().body( "name" , hasItem("Tamara Bartell"))  //v zt tamara is name of all names
                    .assertThat().body( "name" , hasItems("Tamara Bartell" , "Dawn Reinger"))  //v zt tamara & Dawn are names of all names
                    .assertThat().body("name" ,not(hasItem("samir")) ) //v zt samir is not a name of all names
                    //.assertThat().body( "name" , contains("Tamara Bartell" , "Dawn Reinger"))  //should enter all names arranged
                    .assertThat().body( "name" , not(empty()) ) //v zt key: name empty OR not
                    .assertThat().body( "name" , hasSize(25) ) //v zt key: name has 25 value
                    .assertThat().body( "name.size()" , equalTo(25) ) //v zt key: name has 25 value
                    .assertThat().body( "avatar" , everyItem(startsWith("http")) ) //v zt all key: avatar start wiz http
                    .assertThat().body( "[0]" , hasKey("id") ) //v zt the 1st item has key = id
                    .assertThat().body( "[0]" , hasValue("2023-08-09T05:24:39.630Z") ) //v zt the 1st item has value = "2023-08-09T05:24:39.630Z"
                    .assertThat().body( "[0]" , hasEntry("createdAt" , "2023-08-09T05:24:39.630Z") ) //v zt the 1st item has key: "createdAt" and value: "2023-08-09T05:24:39.630Z"

                    .log().all();




    }

}
