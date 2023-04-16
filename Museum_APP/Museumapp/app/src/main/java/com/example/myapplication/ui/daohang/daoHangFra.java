package com.example.myapplication.ui.daohang;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class daoHangFra extends Fragment {
    private BottomNavigationView bottomView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.bottom_menu,container,false);
        return view;
    }
    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        bottomView=(BottomNavigationView)view.findViewById(R.id.nav_view);
    }
}
