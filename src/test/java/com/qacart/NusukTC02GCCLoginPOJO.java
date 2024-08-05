package com.qacart;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class NusukTC02GCCLoginPOJO {
    private String Natioanlity ;
    private String GCCID ;
    private String DeviceID ;
    private String ahmed ;
    private String UserType ;
    private String Latitude ;
    private String Longitude ;

    public NusukTC02GCCLoginPOJO(String Natioanlity, String GCCID, String DeviceID, String Password, String UserType, String Latitude, String Longitude){
        this.Natioanlity = Natioanlity;
        this.GCCID = GCCID;
        this.DeviceID = DeviceID;
        this.ahmed = Password;
        this.UserType = UserType;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    public String getNatioanlity() {
        return Natioanlity;
    }

    public void setNatioanlity(String Natioanlity) {
        this.Natioanlity = Natioanlity;
    }

    public String getGCCID() {
        return GCCID;
    }

    public void setGCCID(String GCCID) {
        this.GCCID = GCCID;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String DeviceID) {
        this.DeviceID = DeviceID;
    }

//    public String getPassword() {
//        return Password;
//    }
//
//    public void setPassword(String Password) {
//        this.Password = Password;
//    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }


}
