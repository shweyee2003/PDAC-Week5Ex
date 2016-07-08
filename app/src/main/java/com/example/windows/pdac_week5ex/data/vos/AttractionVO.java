package com.example.windows.pdac_week5ex.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by windows on 7/6/2016.
 */
public class AttractionVO {
    @SerializedName("title")
    private String Title;

    @SerializedName("desc")
    private String Desc;

    @SerializedName("images")
    private String PhotoPath;


    public AttractionVO(String Title, String Desc, String PhotoPath) {
        this.Title = Title;
        this.PhotoPath = PhotoPath;
        this.Desc = Desc;

    }

    public String getTitle() {
        return Title;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public String getDesc() {
        return Desc;
    }

}
