package com.app.demo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.base.BaseFragment;
import com.app.demo.R;
import com.app.demo.activitys.GSListSearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class StypeFragment extends BaseFragment {


    @BindView(R.id.tv_title_right)
    TextView tv_title_right;
    @BindView(R.id.tv_0)
    TextView tv_0;
    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.tv_2)
    TextView tv_2;



    public static String[] str_durang = new String[]{ "一级文物","二级文物", "三级文物" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stype, container, false);
        ButterKnife.bind(this, view);
        registerEventBus();

        initData();
        return view;
    }

    private void initData() {

        tv_title_right.setVisibility(View.GONE);


        tv_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GSListSearchActivity.class);
                intent.putExtra("stype",str_durang[0]);
                startActivity(intent);
            }
        });

        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GSListSearchActivity.class);
                intent.putExtra("stype",str_durang[1]);
                startActivity(intent);
            }
        });

        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GSListSearchActivity.class);
                intent.putExtra("stype",str_durang[2]);
                startActivity(intent);
            }
        });





    }





}
