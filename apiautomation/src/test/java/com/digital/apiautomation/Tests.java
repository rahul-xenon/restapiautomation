package com.digital.apiautomation;

import com.digital.apiautomation.rest.RESTAssuredClients;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Tests {

    private static  String path ="/apitest";
    private static  String method="GET";
    private static HashMap<String,String> map = new HashMap<String, String>();
    private static String restResponseBody="";
    private static String restResponseHeaders="";
    private static String restStatusCode="";

    @BeforeClass
    public void  setup(){
        RESTAssuredClients  restClient = new RESTAssuredClients(path,method);
        map= restClient.invokeRestApi();
        restResponseBody = map.get("Body");
        restResponseHeaders = map.get("Headers");
        restStatusCode= map.get("StatusCode");
    }


    @Test(priority=1)
    public void validateResponseStatusCode(){
        AssertMethods  asert = new AssertMethods();
        Assert.assertTrue(asert.compareStatusCode(restStatusCode,"200"));
    }

    @Test(priority=2)
    public void validateResponseHeader(){
        AssertMethods  asert = new AssertMethods();
        Assert.assertTrue(asert.compareResponseHeader(restResponseHeaders,"Content-Type=application/json; charset=UTF-8"));
    }


    @Test(priority=3)
    public void validateResponseBody(){
        AssertMethods  asert = new AssertMethods();
        Assert.assertTrue(asert.compareResponseBody(restResponseBody,"{\n" +
                "\"Status\":\"200\",\n" +
                "\"Age\":\"25\",\n" +
                "\"Role\":\"QA Automation Developer\",\n" +
                "\"Dob\":\"25-02-1994\"\n" +
                "}"));

    }

    @Test(priority=4)
    public void validateResponseField(){
        AssertMethods  asert = new AssertMethods();
        Assert.assertTrue(asert.compareResponseBodyField(restResponseBody,"Company","ABC Infotech"));

    }
}
