package com.example.windows.pdac_week5ex.utils;

import android.content.Context;

import com.example.windows.pdac_week5ex.PDACWeek5ExApp;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by windows on 7/6/2016.
 */
public class JsonUtils {

    private static final String PATH_DUMMY_DATA = "dummy_data";
    private static JsonUtils objInstace;
    private Context context;

    public static JsonUtils getInstance() {
        if (objInstace == null) {
            objInstace = new JsonUtils();
        }

        return objInstace;
    }

    private JsonUtils() {
        context = PDACWeek5ExApp.getContext();
    }

    /**
     * Read text from assets folder.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private byte[] readJsonFile(String fileName) throws IOException {
        InputStream inStream = context.getAssets().open(fileName);
        int size = inStream.available();
        byte[] buffer = new byte[size];
        inStream.read(buffer);
        inStream.close();
        return buffer;
    }

    /**
     * @param fileName - name of Json File.
     * @return JSONObject from loaded file.
     * @throws IOException
     * @throws JSONException
     */
    public String loadDummyData(String fileName) throws IOException, JSONException {
        byte[] buffer = readJsonFile(PATH_DUMMY_DATA + "/" + fileName);
        return new String(buffer, "UTF-8").toString();
    }
}
