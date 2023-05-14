package com.app.demo.activitys;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.demo.R;
import com.app.base.BaseActivity;
import com.app.beans.UserBean;
import com.app.utils.StringUtil;
import com.app.utils.TimeUtil;
import com.app.utils.ToastUtil;
import com.app.utils.UserManager;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_name)
    EditText edtName;



    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.layout_pwd)
    LinearLayout layout_pwd;

    UserBean userBean;
    int type = 0;
    String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userBean = (UserBean) bundle.getSerializable("bean");
        }


        if (userBean != null) {
            tvRegister.setText("提交");
            tvTitle.setText("个人信息");
            type = userBean.type;
            edtAccount.setText(userBean.user_id);
            edtAccount.setClickable(false);
            edtAccount.setFocusable(false);
            edtPwd.setText(userBean.password);
            edtName.setText(userBean.name);
            user_id = userBean.user_id;
            layout_pwd.setVisibility(View.GONE);
        } else {
            tvTitle.setText("注册");
            edtAccount.setClickable(true);
            edtAccount.setFocusable(true);

            tvRegister.setText("注册");
            layout_pwd.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.imgv_return, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.tv_register:

                String id = edtAccount.getText().toString();
                String pwd = edtPwd.getText().toString();
                String name = edtName.getText().toString();

                if (StringUtil.isEmpty(id) ||
                        StringUtil.isEmpty(pwd) ||
                        StringUtil.isEmpty(name)  ) {
                    ToastUtil.showToast(this, "请完善信息");
                    return;
                }


                if (userBean != null) {

                    ContentValues values = new ContentValues();
                    values.put("password", pwd);
                    values.put("name", name);
                    values.put("type", type);
                    DataSupport.updateAll(UserBean.class, values, "user_id=?", user_id);

                    ToastUtil.showToast(this, "修改成功");

                } else {

                    if (UserManager.isHaveUser(id)) {
                        ToastUtil.showToast(this, "该账号已存在");
                        return;
                    }

                    UserBean userBean = new UserBean();
                    userBean.setUser_id(id);
                    userBean.setPassword(pwd);
                    userBean.setName(name);
                    userBean.type = type;
                    userBean.setRigster_time(TimeUtil.getTodayData("yyyy-MM-dd HH:mm:ss"));
                    userBean.save();

                    ToastUtil.showToast(this, "注册成功");
                }

                onBackPressed();
                break;
        }

    }

}
