package com.digital.apiautomation;

import com.digital.apiautomation.rest.Utilties;

import java.util.HashMap;
import java.util.Map;

// Seperate Methods for each Assertions

public class AssertMethods {

    public boolean compareStatusCode(String responseStatusCode,String expectedStatusCode){
        try{

            if(responseStatusCode.equalsIgnoreCase(responseStatusCode))
                return true;
            else
                return false;


        }
        catch(Exception e){
            System.out.println("Exception raised in Assert Methods, compareStatusCode "+ e.getStackTrace());
        }

        return false;

    }


    public boolean compareResponseHeader(String responseHeaders,String expectedHeader){
        try{

            if(responseHeaders.contains(expectedHeader))
                return true;
            else
                return false;
        }
        catch(Exception e){
            System.out.println("Exception raised in Assert Methods, compareResponseHeader "+ e.getStackTrace());
        }

        return false;

    }

    public boolean compareResponseBody(String responseBody,String expectedResponseBody){
        try{

            HashMap<String,String> mapResponse = new HashMap<String,String>();
            HashMap<String,String> mapExpectedResponse = new HashMap<String,String>();
            Utilties utl = new Utilties();
            mapResponse = utl.convertStringToHashMap(responseBody);
            mapExpectedResponse = utl.convertStringToHashMap(expectedResponseBody);



            for (Map.Entry<String, String> e : mapResponse.entrySet()) {
                        for (Map.Entry<String, String> eR : mapExpectedResponse.entrySet()) {

                    if (e.getKey().toString().equalsIgnoreCase(eR.getKey().toString())) {
                        if (e.getValue().toString().contains(eR.getValue().toString()))
                            return true;

                        else
                            return false;

                   }

                }
            }
        }
        catch(Exception e){
            System.out.println("Exception raised in Assert Methods, compareResponseBody "+ e.getStackTrace());
        }

        return false;

    }


    public boolean compareResponseBodyField(String responseBody,String expectedKey,String expectedValue){
        try{

            HashMap<String,String> map = new HashMap<String,String>();
            Utilties utl = new Utilties();
            map = utl.convertStringToHashMap(responseBody);

            for (Map.Entry<String, String> e : map.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue());

                if(e.getKey().toString().equalsIgnoreCase(expectedKey)) {
                    if (e.getValue().toString().equalsIgnoreCase(expectedValue))
                        return true;
                    else
                        return false;
                }

            }

        }
        catch(Exception e){
            System.out.println("Exception raised in Assert Methods, compareResponseBodyField "+ e.getStackTrace());
        }

        return false;

    }


}
