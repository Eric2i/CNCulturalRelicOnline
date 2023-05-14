package com.app.demo.activitys;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.MainActivity;
import com.app.demo.R;
import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.beans.UserBean;
import com.app.utils.SharedPreferencesUtil;
import com.app.utils.StringUtil;
import com.app.utils.ToastUtil;
import com.app.utils.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.inputName)
    EditText inputName;
    @BindView(R.id.inputpwd)
    EditText inputpwd;
    @BindView(R.id.imgv_return)
    ImageView imgv_return;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSwipeEnabled(false);
        tvTitle.setText("掌上博物馆");
        imgv_return.setVisibility(View.GONE);
    }

    @OnClick({R.id.imgv_return, R.id.toLogin, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.toLogin:

                if (StringUtil.isEmpty(inputName.getText().toString())) {
                    ToastUtil.showToast(this, "输入账号");
                    return;
                }

                if (StringUtil.isEmpty(inputpwd.getText().toString())) {
                    ToastUtil.showToast(this, "输入密码");
                    return;
                }


                boolean isHaveUser = UserManager.isHaveUser(inputName.getText().toString());
                if (isHaveUser) {//有该用户
                    if (UserManager.isOk(inputName.getText().toString(), inputpwd.getText().toString())) { //密码正确
                        UserBean userBean = UserManager.getUser(inputName.getText().toString());
                        SharedPreferencesUtil.saveDataBean(this, userBean, "user");
                        EventBus.getDefault().post(new EventMessage(EventMessage.LOGIN));
                        showActivity(this, MainActivity.class);
                        finish();
                    } else {
                        ToastUtil.showToast(this, "密码错误");
                    }
                } else {
                    ToastUtil.showToast(this, "无此用户");
                }

                break;
            case R.id.tv_register:
                showActivity(this, RegisterActivity.class);
                break;
        }
    }
}
