package com.example.comp1011200541827test2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JsonUtility {
    public static Customer getCustomerFromFile(String fileName) {
        Gson gson = new Gson();
        try (
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            Type customerType = new TypeToken<Customer>() {}.getType();
            return gson.fromJson(jsonReader, customerType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
