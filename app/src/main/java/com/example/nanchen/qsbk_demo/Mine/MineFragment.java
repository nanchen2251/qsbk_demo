package com.example.nanchen.qsbk_demo.Mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanchen.qsbk_demo.R;

/**
 * Created by nanchen on 2016/5/23.
 */
public class MineFragment extends Fragment {

    public static MineFragment newInstance(){
        return new MineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment,null);
        return view;
    }
}
