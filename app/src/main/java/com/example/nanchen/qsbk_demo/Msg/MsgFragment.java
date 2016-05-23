package com.example.nanchen.qsbk_demo.Msg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanchen.qsbk_demo.R;

/**
 * Created by nanchen on 2016/5/23.
 */
public class MsgFragment extends Fragment {

    public static MsgFragment newInstance(){
        return new MsgFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment,null);
        return view;
    }
}
