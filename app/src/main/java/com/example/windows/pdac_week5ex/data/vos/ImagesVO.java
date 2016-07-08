package com.example.windows.pdac_week5ex.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 7/9/2016.
 */
public class ImagesVO {
    @SerializedName("images")
    private String PhotoPath;

    public String getPhotoPath() {
        return PhotoPath;
    }
}
