package com.digital.apiautomation.rest;

import java.util.HashMap;


public class Utilties {

    public HashMap  convertStringToHashMap(String stringJSON){

        try{

            stringJSON = stringJSON.substring(1, stringJSON.length()-1);
            String[] keyValuePairs = stringJSON.split(",");
            HashMap<String,String> map = new HashMap<String,String>();

            for(String pair : keyValuePairs)
            {
                String[] entry = pair.split(":");
                map.put(entry[0].replace("\"","").trim(), entry[1].replace("\"","").trim());
            }

            return map;

        }
        catch(Exception e){
            System.out.println("Exception raised in Utilties  convertStringToHashMap " + e);
        }


        return null;
    }

  }
