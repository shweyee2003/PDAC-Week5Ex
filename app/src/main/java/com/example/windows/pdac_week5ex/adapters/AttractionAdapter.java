package com.example.windows.pdac_week5ex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows.pdac_week5ex.PDACWeek5ExApp;
import com.example.windows.pdac_week5ex.R;
import com.example.windows.pdac_week5ex.data.vos.AttractionVO;
import com.example.windows.pdac_week5ex.fragments.MainActivityFragment;
import com.example.windows.pdac_week5ex.views.holders.AttractionViewHolder;

import java.util.List;

/**
 * Created by windows on 7/6/2016.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {
    private LayoutInflater inflater;
    private List<AttractionVO> attractionList;
    private MainActivityFragment.ControllerAttractionItem mAttractionItemController;

    public AttractionAdapter(List<AttractionVO> attractionList, MainActivityFragment.ControllerAttractionItem attractionItemController)
    {
        inflater = LayoutInflater.from(PDACWeek5ExApp.getContext());
        this.attractionList=attractionList;
        mAttractionItemController = attractionItemController;
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_attraction, parent, false);
        final AttractionViewHolder attractionVH=new AttractionViewHolder(view,mAttractionItemController);
        return attractionVH;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(attractionList.get(position));
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }
}
