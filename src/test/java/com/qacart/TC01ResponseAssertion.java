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
                    .assertThat().body( "[0].name" , equalTo("Evan Kling")) //v zt name of 1st item is Evan Kling OR
                    //.assertThat().body( "[0].name" , is(equalTo("Evan Kling"))  )
                    .assertThat().body( "name" , hasItem("Evan Kling"))  //v zt Evan is a name of all names
                    .assertThat().body( "name" , hasItems("Evan Kling" , "Madiha"))  //v zt Evan & Madiha are names of all names
                    .assertThat().body("name" ,not(hasItem("samir")) ) //v zt samir is not a name of all names
                    //.assertThat().body( "name" , contains("Tamara Bartell" , "Dawn Reinger"))  //should enter all names arranged (num + order)
                    //.assertThat().body( "name" , containsInAnyOrder("Tamara Bartell" , "Dawn Reinger"))  //should enter all names (num)
                    .assertThat().body( "name" , not(empty()) ) //v zt key: name empty OR not
                    .assertThat().body( "name" , hasSize(50) ) //v zt key: name has 50 value
                    .assertThat().body( "name.size()" , equalTo(50) ) //v zt key: name has 50 value
                    .assertThat().body( "avatar" , everyItem(startsWith("http")) ) //v zt all key: avatar start wiz http
                    .assertThat().body( "[0]" , hasKey("id") ) //v zt the 1st item has key = id
                    .assertThat().body( "[0]" , hasValue("2024-07-20T13:45:17.091Z") ) //v zt the 1st item has value = "2023-08-09T05:24:39.630Z"
                    .assertThat().body( "[0]" , hasEntry("createdAt" , "2024-07-20T13:45:17.091Z") ) //v zt the 1st item has key: "createdAt" and value: "2023-08-09T05:24:39.630Z"

                    // more than one assertion in the same line
                    .assertThat().body( "[0].name" , equalTo("Evan Kling") ,
                            "name" , hasItem("Evan Kling"))
                    
                    .log().all();




    }

}
