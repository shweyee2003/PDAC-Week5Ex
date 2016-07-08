package com.example.windows.pdac_week5ex.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.windows.pdac_week5ex.R;
import com.example.windows.pdac_week5ex.data.vos.AttractionVO;
import com.example.windows.pdac_week5ex.fragments.MainActivityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by windows on 7/6/2016.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private AttractionVO mAttraction;
    private MainActivityFragment.ControllerAttractionItem mAttractionItemController;

    public  AttractionViewHolder(View view,MainActivityFragment.ControllerAttractionItem attractionItemController)
    {
        super(view);
        ButterKnife.bind(this,view);
        view.setOnClickListener(this);
        mAttractionItemController=attractionItemController;
    }
    public  void setData(AttractionVO attraction)
    {
        this.mAttraction=attraction;

        tvTitle.setText(attraction.getTitle());
        tvDesc.setText(attraction.getDesc());

        Glide.with(ivPhoto.getContext())
                .load(attraction.getPhotoPath())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .into(ivPhoto);
    }
    @Override
    public void onClick(View v) {
        mAttractionItemController.onTapAttraction(mAttraction,ivPhoto);
    }
}
