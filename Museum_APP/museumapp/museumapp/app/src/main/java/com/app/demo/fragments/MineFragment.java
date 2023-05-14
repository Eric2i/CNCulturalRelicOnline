package com.app.demo.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.app.demo.R;
import com.app.demo.activitys.GSLiulanListActivity;
import com.app.demo.activitys.GSShoucangListActivity;
import com.app.demo.activitys.LoginActivity;
import com.app.demo.activitys.PassWordResetActivity;
import com.app.demo.activitys.RegisterActivity;
import com.app.base.BaseFragment;
import com.app.utils.DialogUtil;
import com.app.utils.SharedPreferencesUtil;
import com.app.utils.UserManager;
import com.app.widgts.CustomDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    private String dialog_title = "退出登录";
    private String dialog_content = "是否确定退出登录？";
    private CustomDialog customDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        registerEventBus();
        return view;
    }

    @OnClick({R.id.tv_my_info, R.id.tv_shoucang,  R.id.tv_pwd, R.id.tv_logout,R.id.tv_liulan})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.tv_my_info:
                bundle.putSerializable("bean", UserManager.getUser(UserManager.getUserId(getActivity())));
                skipActivity(getActivity(), RegisterActivity.class, bundle);
                break;
            case R.id.tv_shoucang:
                bundle.putString("from", "manager");
                skipActivity(getActivity(), GSShoucangListActivity.class, bundle);
                break;
            case R.id.tv_liulan:

                skipActivity(getActivity(), GSLiulanListActivity.class, bundle);
                break;

            case R.id.tv_pwd:
                skipActivity(getActivity(), PassWordResetActivity.class);
                break;
            case R.id.tv_logout:
                Logout();

                break;
        }
    }


    private void Logout() {
        customDialog = DialogUtil.showDialog(getActivity(), customDialog, 2, dialog_title, dialog_content, "取消", "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                SharedPreferencesUtil.removeAll(getActivity(), "user");
                skipActivity(getActivity(), LoginActivity.class);
                getActivity().finish();
            }
        });

        if (customDialog != null && !customDialog.isShowing()) {
            customDialog.show();
        }


        customDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                customDialog = null;
            }
        });
    }


}
