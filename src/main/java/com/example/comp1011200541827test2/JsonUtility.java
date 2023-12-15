package com.example.comp1011200541827test2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class JsonUtility {
    public static Business getBusinessFromFile(String fileName) {
        Gson gson = new Gson();
        try (
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            return gson.fromJson(jsonReader, Business.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
