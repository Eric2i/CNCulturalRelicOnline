package com.app.demo.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.MyWebActivity;
import com.app.demo.R;
import com.app.demo.beans.GSBean;
import com.app.demo.beans.GSRecordBean;
import com.app.demo.beans.GSShoucangBean;
import com.app.demo.shares.I_OnShareCallBack;
import com.app.demo.shares.ShareUtil;
import com.app.utils.TimeUtil;
import com.app.utils.ToastUtil;
import com.app.utils.UserManager;
import com.umeng.socialize.UMShareAPI;

import org.litepal.crud.DataSupport;

import java.sql.Time;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GSDetailActivity extends Activity {

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
    @BindView(R.id.tv_close)
    TextView tv_close;

    GSBean gsBean;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_detail);
//        //设置布局长宽
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.height = (int) (getWindowManager().getDefaultDisplay().getHeight() * 0.8); // 高度设置为屏幕的0.3
//        params.width = (int) (getWindowManager().getDefaultDisplay().getWidth() * 0.8); // 宽度设置为屏幕的0.8
//        params.alpha = 1f; //透明度;
//        getWindow().setAttributes(params);



        ButterKnife.bind(this);

        //set view
        gsBean = (GSBean) getIntent().getSerializableExtra("bean");
        iv_pic.setImageResource(gsBean.pic);
        tv_name.setText(gsBean.name);
        tv_theme.setText(gsBean.theme);
        tv_content.setText(gsBean.content);

        user_id = UserManager.getUserId(this);
        List<GSShoucangBean> list = DataSupport.findAll(GSShoucangBean.class);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ids.equals(gsBean.ids) && list.get(i).userId.equals(user_id)) {
                tv_shoucang.setText("已收藏");
            } else {
                tv_shoucang.setText("收藏");
            }
        }
        savaRecord();
    }

    private void savaRecord(){
        GSRecordBean bean = new GSRecordBean();
        bean.sc_id = TimeUtil.getTodayData("yyyy-MM-dd HH:mm:ss") + "";
        bean.userId = user_id;
        bean.ids = gsBean.ids;

        bean.pic = gsBean.pic;
        bean.name = gsBean.name;
        bean.theme = gsBean.theme;
        bean.content = gsBean.content;

        bean.save();
    }


    @OnClick({    R.id.tv_1, R.id.tv_shoucang, R.id.tv_fenxiang, R.id.tv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                ToastUtil.showToast(this, "点赞成功");
                break;
            case R.id.tv_close:
                finish();
                break;

            case R.id.tv_shoucang:
                if (tv_shoucang.getText().toString().equals("收藏")) {
                    GSShoucangBean bean = new GSShoucangBean();
                    bean.sc_id = System.currentTimeMillis() + "";
                    bean.userId = user_id;
                    bean.ids = gsBean.ids;

                    bean.pic = gsBean.pic;
                    bean.name = gsBean.name;
                    bean.theme = gsBean.theme;
                    bean.content = gsBean.content;

                    bean.save();
                    ToastUtil.showToast(this, "收藏成功");
                    onBackPressed();
                } else {
                    ToastUtil.showToast(this, "已收藏，无需再次收藏");
                }
                break;
            case R.id.tv_fenxiang:
                ShareUtil.share(GSDetailActivity.this, gsBean.content, gsBean.name, "https://www.toutiao.com/a6902226785228915211/?channel=&source=search_tab", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.puchedu.cn%2Fuploads%2F3%2F26%2F251294644%2F174425602.jpg&refer=http%3A%2F%2Fimg.puchedu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640846328&t=d7399d80c439e58d2973d15cb001a401", 0, new I_OnShareCallBack() {
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
