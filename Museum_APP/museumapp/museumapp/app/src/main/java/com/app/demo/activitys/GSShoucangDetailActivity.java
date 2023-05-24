package com.app.demo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.MyWebActivity;
import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.demo.R;
import com.app.demo.beans.GSShoucangBean;
import com.app.demo.shares.I_OnShareCallBack;
import com.app.demo.shares.ShareUtil;
import com.app.utils.ToastUtil;
import com.umeng.socialize.UMShareAPI;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class GSShoucangDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_pic)
    ImageView iv_pic;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_theme)
    TextView tv_theme;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_shoucang)
    TextView tv_shoucang;
    @BindView(R.id.tv_fenxiang)
    TextView tv_fenxiang;


    GSShoucangBean gsShoucangBean;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_shoucang_detail);
        ButterKnife.bind(this);

        tvTitle.setText("详情");

        gsShoucangBean = (GSShoucangBean) getIntent().getSerializableExtra("bean");
        iv_pic.setImageResource(gsShoucangBean.pic);
        tv_name.setText(gsShoucangBean.name);
        tv_theme.setText(gsShoucangBean.theme);
        tv_content.setText(gsShoucangBean.content);

    }


    @OnClick({R.id.imgv_return, R.id.tv_shoucang, R.id.tv_fenxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

            case R.id.tv_shoucang:
                DataSupport.deleteAll(GSShoucangBean.class, "sc_id = ? ", gsShoucangBean.sc_id);
                ToastUtil.showToast(this, "已从收藏中移除");
                onBackPressed();
                EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));

                break;
            case R.id.tv_fenxiang:
                ShareUtil.share(GSShoucangDetailActivity.this, gsShoucangBean.content, gsShoucangBean.name, "https://www.toutiao.com/a6902226785228915211/?channel=&source=search_tab", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.puchedu.cn%2Fuploads%2F3%2F26%2F251294644%2F174425602.jpg&refer=http%3A%2F%2Fimg.puchedu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640846328&t=d7399d80c439e58d2973d15cb001a401", 0, new I_OnShareCallBack() {
                    @Override
                    public void onShareSuccess(String shareChannel) {

                    }

                    @Override
                    public void onShareCancel(String shareChannel) {

                    }

                    @Override
                    public void onShareError(String shareChannel) {

                    }
                });
                break;
        }
    }

    //分享
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
