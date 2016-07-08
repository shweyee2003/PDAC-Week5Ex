package com.example.windows.pdac_week5ex.utils;

import com.google.gson.Gson;

/**
 * Created by windows on 7/6/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
