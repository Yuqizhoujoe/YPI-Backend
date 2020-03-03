package com.ypi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readJSONFile {

    public static void main(String[] args) {

        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;

        try {
            reader = new FileReader("assets/data.json");
            // read json file
            Object obj = jsonParser.parse(reader);

            JSONArray resourceList = (JSONArray) obj;
            System.out.println(resourceList);

            // Iterate over resource array
            for (Object resource : resourceList) {
                parseResourceObject((JSONObject) resource);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void parseResourceObject(JSONObject resource) {
        // get resource name
        String resourceName = (String) resource.get("name");
        System.out.println(resourceName);
        // get cost_code
        String cost_code = (String) resource.get("codeNumber");
        System.out.println(cost_code);
    }



}
