package com.app.demo.activitys;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.demo.R;
import com.app.base.BaseActivity;
import com.app.beans.UserBean;
import com.app.utils.SharedPreferencesUtil;
import com.app.utils.StringUtil;
import com.app.utils.ToastUtil;
import com.app.utils.UserManager;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassWordResetActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.inputpwd_new)
    EditText inputpwdNew;
    @BindView(R.id.inputpwd_repeat)
    EditText inputpwdRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_reset);
        ButterKnife.bind(this);

        tvTitle.setText("重置密码");
    }

    @OnClick({R.id.imgv_return, R.id.tv_modify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;
            case R.id.tv_modify:

                if (StringUtil.isEmpty(inputpwdNew.getText().toString())) {
                    ToastUtil.showToast(this, "请输入新密码");
                    return;
                }

                if (StringUtil.isEmpty(inputpwdRepeat.getText().toString())) {
                    ToastUtil.showToast(this, "请再次输入新密码");
                    return;
                }

                if (!inputpwdNew.getText().toString().equals(inputpwdRepeat.getText().toString())) {
                    ToastUtil.showToast(this, "两次密码不一致");
                    return;
                }


                ContentValues values = new ContentValues();
                values.put("password", inputpwdNew.getText().toString());
                SharedPreferencesUtil.saveData(this, "user", "password", inputpwdNew.getText().toString());
                DataSupport.updateAll(UserBean.class, values, "user_id=?", UserManager.getUserId(this));

                ToastUtil.showToast(this, "修改成功");

                onBackPressed();

                break;
        }
    }
}
