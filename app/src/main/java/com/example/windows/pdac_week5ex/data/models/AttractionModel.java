package com.example.windows.pdac_week5ex.data.models;

import com.example.windows.pdac_week5ex.data.vos.AttractionVO;
import com.example.windows.pdac_week5ex.data.vos.ImagesVO;
import com.example.windows.pdac_week5ex.utils.CommonInstances;
import com.example.windows.pdac_week5ex.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by windows on 7/6/2016.
 */
public class AttractionModel {
    private static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";

    private static AttractionModel objInstance;

    private List<AttractionVO> attractionList;

    private AttractionModel(){
        attractionList = initializeAttractionList();
    }

    public static AttractionModel getInstance(){
        if(objInstance == null) {
            objInstance = new AttractionModel();
        }

        return objInstance;
    }

    private List<AttractionVO> initializeAttractionList() {
        List<AttractionVO> attractionList = new ArrayList<>();

        try {
            String dummyAttractionList = JsonUtils.getInstance().loadDummyData(DUMMY_ATTRACTION_LIST);
            Type listType = new TypeToken<List<AttractionVO>>() {
            }.getType();
            attractionList = CommonInstances.getGsonInstance().fromJson(dummyAttractionList, listType);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return attractionList;
    }

    public List<AttractionVO> getAttractionList() {
        return attractionList;
    }

    public AttractionVO getAttractionByTitle(String Title) {
        for (AttractionVO attracion : attractionList) {
            if (attracion.getTitle().equals(Title)) {
                return attracion;
            }
        }
        return null;
    }


}
