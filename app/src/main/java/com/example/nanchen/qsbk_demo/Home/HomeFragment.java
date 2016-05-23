package com.example.nanchen.qsbk_demo.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanchen.qsbk_demo.R;

/**
 * Created by nanchen on 2016/5/23.
 */
public class HomeFragment extends Fragment {


    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,null);
        return view;
    }
}
