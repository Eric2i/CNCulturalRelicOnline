package com.app.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.base.BaseActivity;
import com.app.base.BaseFragment;
import com.app.demo.activitys.LoginActivity;
import com.app.demo.fragments.MineFragment;
import com.app.demo.fragments.StypeFragment;
import com.app.demo.fragments.TuijianFragment;
import com.app.utils.UserManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.txt_1)
    TextView txt_1;
    @BindView(R.id.txt_2)
    TextView txt_2;
    @BindView(R.id.txt_3)
    TextView txt_3;

    Fragment mFragment;
    BaseFragment fragment1,   fragment2, fragment3;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSwipeEnabled(false); //主页面取消右划返回功能
        initData();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void initData() {
        if (!UserManager.isLogin(this)) {
            showActivity(this, LoginActivity.class);
            finish();
        } else {
            mFragment = new Fragment();
            checkPosition(1);
        }
    }


    /**
     * 更换fragment
     *
     * @param from
     * @param to
     */
    public void switchContent(Fragment from, Fragment to) {
        if (mFragment != to) {
            mFragment = to;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.fragment_container, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    @OnClick({R.id.txt_1, R.id.txt_2,   R.id.txt_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_1:
                checkPosition(1);
                break;
            case R.id.txt_2:
                checkPosition(2);
                break;

            case R.id.txt_3:
                checkPosition(3);
                break;
        }
    }


    private void checkPosition(int position) {

        if (position == 1) {
//            if (fragment1 == null) {
                fragment1 = new TuijianFragment();
//            }
            txt_1.setSelected(true);
            txt_2.setSelected(false);
            txt_3.setSelected(false);
            switchContent(mFragment, fragment1);

        } else if (position == 2) {
            if (fragment2 == null) {
                fragment2 = new StypeFragment();
            }
            txt_1.setSelected(false);
            txt_2.setSelected(true);
            txt_3.setSelected(false);
            switchContent(mFragment, fragment2);
        } else if (position == 3) {
            if (fragment3 == null) {
                fragment3 = new MineFragment();
            }
            txt_1.setSelected(false);
            txt_2.setSelected(false);
            txt_3.setSelected(true);
            switchContent(mFragment, fragment3);
        }

    }

}
