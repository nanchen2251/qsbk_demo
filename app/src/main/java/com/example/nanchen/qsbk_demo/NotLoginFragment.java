package com.example.nanchen.qsbk_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nanchen.qsbk_demo.Mine.LoginActivity;

/**
 * Created by nanchen on 2016/5/23.
 */
public class NotLoginFragment extends Fragment {

    public static NotLoginFragment newInstance(){
        return new NotLoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.not_login_fragment,null);
        Button go_login = (Button) view.findViewById(R.id.go_login);
        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),LoginActivity.class));
            }
        });
        return view;
    }
}
