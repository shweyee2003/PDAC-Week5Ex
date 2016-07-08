package com.example.windows.pdac_week5ex.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.windows.pdac_week5ex.PDACWeek5ExApp;
import com.example.windows.pdac_week5ex.R;
import com.example.windows.pdac_week5ex.data.models.AttractionModel;
import com.example.windows.pdac_week5ex.data.vos.AttractionVO;

public class AttractionDetailActivity extends AppCompatActivity {

    private static final String IE_TITLE = "IE_TITLE";

    private ImageView ivPhoto;
    private TextView tvDesc;
    private CollapsingToolbarLayout collapsingToolbar;
    private AttractionVO attraction;



    public static Intent newIntent(String Title) {
        Intent intent = new Intent(PDACWeek5ExApp.getContext(), AttractionDetailActivity.class);
        intent.putExtra(IE_TITLE, Title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            ivPhoto = (ImageView) findViewById(R.id.iv_photo);
            Context context=PDACWeek5ExApp.getContext();
            String transitionName = getResources().getString(R.string.attraction__photo_shared_transition);
            ivPhoto.setTransitionName(transitionName);
        }

        tvDesc = (TextView) findViewById(R.id.tv_desc);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {

//            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_accent_24dp);
        }
        AppBarLayout appbar=(AppBarLayout) findViewById(R.id.appbar);

        String title = getIntent().getStringExtra(IE_TITLE);

        attraction = AttractionModel.getInstance().getAttractionByTitle(title);
        if(attraction == null) {
            throw new RuntimeException("Can't find Attaction obj with the title : "+title);
        } else {
            collapsingToolbar.setTitle(attraction.getTitle());
            tvDesc.setText(attraction.getDesc());


            Glide.with(ivPhoto.getContext())
                    .load(attraction.getPhotoPath())
                    .centerCrop()
                    .placeholder(R.drawable.stock_photo_placeholder)
                    .into(ivPhoto);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_share);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(createShareIntent(attraction.getPhotoPath()));
                Snackbar.make(view, attraction.getPhotoPath(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private static Intent createShareIntent(String photopath){

        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
        Uri imageUri = Uri.parse(photopath);
       // myShareIntent.setType("image/*");
        myShareIntent.setType("text/*");
        myShareIntent.putExtra(Intent.EXTRA_TEXT, photopath);
        //myShareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        Toast.makeText(PDACWeek5ExApp.getContext(), photopath,Toast.LENGTH_SHORT).show();

        return myShareIntent;
    }

}
