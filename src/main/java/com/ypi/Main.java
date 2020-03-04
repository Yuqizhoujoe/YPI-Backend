package com.ypi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // instantiate ResourceApplication
        ResourceApplication ra = new ResourceApplication();
        JSONArray resourseArray = null;

        // import file
        readJSONFile read = new readJSONFile();
        resourseArray = read.readJSON();
        for (Object resource : resourseArray) {
            String resourceName = read.parseResourceName((JSONObject) resource);
            String cost_code = read.parseResourceCostCode((JSONObject) resource);
            // insert values into Resource table
            ra.insertResource(resourceName, cost_code);
        }

    }

}
