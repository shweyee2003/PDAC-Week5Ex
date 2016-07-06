package com.example.windows.pdac_week5ex;

import android.app.Application;
import android.content.Context;

/**
 * Created by windows on 7/6/2016.
 */
public class PDACWeek5ExApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
