package com.example.windows.pdac_week5ex.fragments;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows.pdac_week5ex.R;
import com.example.windows.pdac_week5ex.adapters.AttractionAdapter;
import com.example.windows.pdac_week5ex.data.models.AttractionModel;
import com.example.windows.pdac_week5ex.data.vos.AttractionVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private AttractionAdapter mAttractionAdapter;
    private ControllerAttractionItem mAttractionItemController;

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAttractionItemController = (ControllerAttractionItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAttractionAdapter = new AttractionAdapter(AttractionModel.getInstance().getAttractionList(),mAttractionItemController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView rvEvent = (RecyclerView) view.findViewById(R.id.rv_events);
       rvEvent.setAdapter(mAttractionAdapter);
       rvEvent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);//to hide loader
                    }
                }, 3000);//ms>milli second
            }
        });

        return view;
    }

    public interface ControllerAttractionItem {
        void onTapAttraction(AttractionVO attraction, ImageView ivPhoto);
    }
}
