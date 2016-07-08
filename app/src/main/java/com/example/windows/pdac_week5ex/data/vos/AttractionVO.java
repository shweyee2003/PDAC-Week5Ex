package com.example.windows.pdac_week5ex.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by windows on 7/6/2016.
 */
public class AttractionVO {
    @SerializedName("title")
    private String Title;

    @SerializedName("desc")
    private String Desc;
    @SerializedName("images")
    private String[] imagespath;

    private String PhotoPath;


//    ArrayList<ImagesVO> availabelImagesList;


    public AttractionVO(String Title, String Desc, String[] imagespath) {
        this.Title = Title;
        //this.availabelImagesList = imagesList;
        this.Desc = Desc;
        this.imagespath=imagespath;
//        System.out.println(imagespath.length);
//        for (int i=0; i<imagespath.length; i++)
//        {
//            System.out.println(imagespath[i]);
//        }
       this.PhotoPath=imagespath[0];
    }

    public String getTitle() {
        return Title;
    }
//
//    public ArrayList<ImagesVO> getImageList() {
//        return availabelImagesList;
//    }


    public String getPhotoPath() {
        this.PhotoPath=imagespath[0];
        return PhotoPath;
    }

    public String getDesc() {
        return Desc;
    }

}
