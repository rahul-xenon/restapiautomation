package com.digital.apiautomation.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.HashMap;

public class RESTAssuredClients {

    final static String ROOT_URI = "http://demo4032024.mockable.io";
    private static String method ="";
    private static String path ="";
    HashMap<String,String> map = new  HashMap<String,String>();

    public  RESTAssuredClients(){
        this.method="GET";
        this.path="/apitest";
    }

    public  RESTAssuredClients(String path, String method){
        this.method=method;
        this.path=path;
    }

    public HashMap invokeRestApi(){
        try{
            if(this.method.equalsIgnoreCase("GET")){
                RestAssured.baseURI = ROOT_URI;
                RequestSpecification request = RestAssured.given();
                Response response = request.request(Method.GET, this.path);
                String responseBody = response.getBody().asString();
                String responseHeaders = response.getHeaders().toString();
                String responseStatusCode = String.valueOf(response.getStatusCode());
                map.put("StatusCode",responseStatusCode);
                map.put("Headers",responseHeaders);
                map.put("Body",responseBody);

                return map;
            }
            else
                System.out.println("This Framework Supports Only GET Request. Please wait for enhancements.");

        }
        catch(Exception e){
            System.out.println("Exception raised in invokeRestAPI Method " + e);
        }

        return null;
    }


}
