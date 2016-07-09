package com.example.windows.pdac_week5ex.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows.pdac_week5ex.R;
import com.example.windows.pdac_week5ex.adapters.AttractionAdapter;
import com.example.windows.pdac_week5ex.data.vos.AttractionVO;
import com.example.windows.pdac_week5ex.fragments.MainActivityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements MainActivityFragment.ControllerAttractionItem {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    private AttractionAdapter mAttractionAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//    @BindView(R.id.rv_events)
//    RecyclerView rvattraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rvattraction.setHasFixedSize(true);

//        mLayoutManager = new LinearLayoutManager(this);
//        rvattraction.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//       // mAttractionAdapter = new MyAdapter(myDataset);
//        rvattraction.setAdapter(mAttractionAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        //setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            MainActivityFragment fragment = MainActivityFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapAttraction(AttractionVO attraction, ImageView ivPhoto) {
        Intent intent=AttractionDetailActivity.newIntent(attraction.getTitle());
        ActivityOptionsCompat activityOptions=ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair(ivPhoto,getString(R.string.attraction__photo_shared_transition)));
        ActivityCompat.startActivity(this,intent,activityOptions.toBundle());
    }
}
