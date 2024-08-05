package com.qacart;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class NusukTC01GCCLogin {
    String userID ;
    String uri = "https://api-huic.haj.gov.sa/TEST/eatamarna/" ;
    // Hashmap for body or header
//    HashMap<String,String> headers = new HashMap<>();
//    headers.put("Content-Type", "application/json");
//    Headers.put("User-Agent", "PostmanRuntime/7.40.0");  etc ...


    @Test
    public void testGCCLogin(){

        //NusukTC02GCCLoginPOJO bodyPOJO = new NusukTC02GCCLoginPOJO();
//        bodyPOJO.setNatioanlity("965");
//        bodyPOJO.setGCCID("1561317011");
//        bodyPOJO.setDeviceID("ef3d44b57bb61c12");
//        bodyPOJO.setPassword("596819450@Aa");
//        bodyPOJO.setUserType("2");
//        bodyPOJO.setLatitude("");
//        bodyPOJO.setLongitude("");
        // to read the body from a pojo class via (setter & getter) (B1)
        //NusukTC02GCCLoginPOJO bodyPOJO2= new NusukTC02GCCLoginPOJO("965", "1561317011", "ef3d44b57bb61c12", "596819450@Aa", "2", "", "");
        // to read the body from a pojo class via (constructor) (C1)

        File body = new File("src/test/resources/login.json");
        // to read the body from a json file (A1)

            Response res = given().baseUri(uri)
                    //.auth().oauth2("token")
                    // in case I must write token as a Bearer token in 'Authorization' OR
                    //.header("Authorization", "token")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "PostmanRuntime/7.40.0")
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJKV1QiLCJhcHBVc2VyIjoiSldUIiwiYXVkIjoiSldUIiwibmJmIjoxNjc3NDE2NDc1LCJpc3MiOiJTZWplbCIsImV4cCI6MTcwODk1MjQ3NSwiY29uc3VtZXJLZXkiOiJKV1QiLCJpYXQiOjE2Nzc0MTY0NzUsImp0aSI6IjE5ODcyIn0.ff1DgzOoCozAQwTuHVV0nFMq8mwJzhGgizqH34FONuDevYRqC9Svr5Drx8LaAwPTxsiF5qbK5erkAFbiHrGXEXYiakhEcNWm8tAuuorbpKxEuzowH6cIuQ5AzDeil8v0hPZILqJcC8slOhLbhRWYP4psty0I1e_9MJ8VGduX_7g24Y_t868XFrVEJUFCrpD-InsBUAD0G1czKEJGbedr4g42G5tkIPTrGa9FCkG59_PM6N7Gl8ACClC3dLjB791zv3T2vnVCc1Y4Frs_Vvm8TKmJHCW_BbYVqiFozRQYbCcQpnL-BNem0g8LiJERFF5q6wjav9-EHn4ZhbW7fghqZg")
                    .header("Accept", "application/json")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Connection", "keep-alive")
                    .header("hash" , "54e64aed337b81314af9ac8e58a2d919fb59bc2dd8f2915b1650d2273220cac8")
                    .header("timestamp", "1673777674132")
                    .header("Version", "9")
                    .header("deviceType", "iOS")
                    .header("appVersion", "9.1")
                    //OR .header(headers) to read header from HashMap object & Add jackson-databind dependency
                    .body("{\"Natioanlity\": 965, \"GCCID\": \"1561317011\",  \"DeviceID\": \"ef3d44b57bb61c12\", \"Latitude\": \"\", \"Longitude\": \"\", \"Password\": \"596819450@Aa\",  \"UserType\": 2}")
                    //OR .body(body)
                    // to read the body from a json file (A2)
                    //OR .body(bodyPOJO)
                    // to read the body from a pojo class (B2)
                    //OR .body(bodyPOJO2)
                    // to read the body from a pojo class (C2)
                    .log().all() // to extract the request
                    .when().post("login")
                    .then().extract().response() ;

             System.out.println(res.asString()); // print all response


        userID = JsonPath.from(res.asString()).getString("Response.UserID") ;
        String user = res.jsonPath().getString("Response.UserID");
        System.out.println(userID);
        System.out.println(user);



    }
    @Test
    public void testGCCVerifyLogin(){

        Response res = given().baseUri(uri)
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.40.0")
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJKV1QiLCJhcHBVc2VyIjoiSldUIiwiYXVkIjoiSldUIiwibmJmIjoxNjc3NDE2NDc1LCJpc3MiOiJTZWplbCIsImV4cCI6MTcwODk1MjQ3NSwiY29uc3VtZXJLZXkiOiJKV1QiLCJpYXQiOjE2Nzc0MTY0NzUsImp0aSI6IjE5ODcyIn0.ff1DgzOoCozAQwTuHVV0nFMq8mwJzhGgizqH34FONuDevYRqC9Svr5Drx8LaAwPTxsiF5qbK5erkAFbiHrGXEXYiakhEcNWm8tAuuorbpKxEuzowH6cIuQ5AzDeil8v0hPZILqJcC8slOhLbhRWYP4psty0I1e_9MJ8VGduX_7g24Y_t868XFrVEJUFCrpD-InsBUAD0G1czKEJGbedr4g42G5tkIPTrGa9FCkG59_PM6N7Gl8ACClC3dLjB791zv3T2vnVCc1Y4Frs_Vvm8TKmJHCW_BbYVqiFozRQYbCcQpnL-BNem0g8LiJERFF5q6wjav9-EHn4ZhbW7fghqZg")
                .header("Accept", "application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("hash" , "54e64aed337b81314af9ac8e58a2d919fb59bc2dd8f2915b1650d2273220cac8")
                .header("timestamp", "1673777674132")
                .header("Version", "9")
                .header("deviceType", "iOS")
                .header("appVersion", "9.1")
                .body("{\n" +
                        "  \"DeviceID\": \"ef3d44b57bb61c12\",\n" +
                        "  \"OTP\": \"1111\",\n" +
                        "  \"User\": \"" + userID + "\"\n" +
                        "}")
                .when().post("VerifyLogin")
                .then()
                .extract().response() ;

        System.out.println(res.asString()); // print all response


    }


}
