package com.app.demo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.base.BaseFragment;
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

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TuijianFragment extends BaseFragment {


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

    String user_id;
    GSBean gsBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuijian, container, false);
        ButterKnife.bind(this, view);
        registerEventBus();
        initData();
        return view;
    }


    private void initData() {


        List<GSBean> temp2 = DataSupport.findAll(GSBean.class);
        if (temp2.size() <= 0) {
            addData();
        }
        //随机取一组数据，添加推荐列表
        List<GSBean> temp = DataSupport.findAll(GSBean.class);
        int s0 = new Random().nextInt(temp.size());
        gsBean = temp.get(s0);
        //set view
        iv_pic.setImageResource(gsBean.pic);
        tv_name.setText(gsBean.name);
        tv_theme.setText(gsBean.theme);
        tv_content.setText(gsBean.content);

        user_id = UserManager.getUserId(getActivity());
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


    public void addData() {

        for (int i = 0; i < 11; i++) {

            int pic = 0;
            String temp_name = "";
            String temp_theme = "";
            String temp_content = "";

            if (i == 0) {
                pic = R.mipmap.h0;
                temp_name = "A Mandarin's Autumn Hat";
                temp_theme = "一级文物";
                temp_content = "Gift of Mrs. Harold Ahlquist.\n" +
                        "\n" +
                        "Dynasty:Neoteric Times\n" +
                        "\n" +
                        "Type:Silk hat";
            } else if (i == 1) {
                pic = R.mipmap.h1;
                temp_name = "A Hermitage";
                temp_theme = "一级文物";
                temp_content = "Gift of Mr. S. M. Hsiao, Hong Kong.\n" +
                        "\n" +
                        "Dynasty:Neoteric Times\n" +
                        "\n" +
                        "Type:Painting \n";

            } else if (i == 2) {
                pic = R.mipmap.h2;
                temp_name = "Ancestor Portrait: Qing Official and Wives";
                temp_theme = "一级文物";
                temp_content = "Museum purchase.\n" +
                        "Dynasty:19th century\n" +
                        "Type:Scroll Painting Color on paper";
            } else if (i == 3) {
                pic = R.mipmap.h3;
                temp_name = "Archer's Ring";
                temp_theme = "一级文物";
                temp_content = "Gift of Mrs. John Sheafe Douglas.\n" +
                        "\n" +
                        "Dynasty:19th century\n" +
                        "\n" +
                        "Type:Jade Ring";
            } else if (i == 4) {
                pic = R.mipmap.h4;
                temp_name = "Armorial Plate";
                temp_theme = "二级文物";
                temp_content = "Gift of Dr. and Mrs. Paul W. Greeley.\n" +
                        "\n" +
                        "Dynasty:late 18th century-early 19th century\n" +
                        "\n" +
                        "Type:Ceramic Plate";
            } else if (i == 5) {
                pic = R.mipmap.h5;
                temp_name = "Betelnut Container";
                temp_theme = "二级文物";
                temp_content = "Gift of Isamu Kawaguchi.\n" +
                        "\n" +
                        "Dynasty:19th century\n" +
                        "\n" +
                        "Type:Wood Container";
            }else if (i == 6) {
                pic = R.mipmap.h6;
                temp_name = "Bowl";
                temp_theme = "二级文物";
                temp_content = "Bequest of Mrs. Cora Timken Burnett.\n" +
                        "\n" +
                        "Dynasty:1368-1644\n" +
                        "\n" +
                        "Type:Porcelain Bowl\n" +
                        "\n" ;
            }else if (i == 7) {
                pic = R.mipmap.h7;
                temp_name = "Brush Washer";
                temp_theme = "三级文物";
                temp_content = "Gift of Dr. Paul S. Anderson.\n" +
                        "\n" +
                        "Dynasty:1662-1722\n" +
                        "\n" +
                        "Type:Porcelain Washer\n" +
                        "\n";
            }
            else if (i == 8) {
                pic = R.mipmap.h8;
                temp_name = "Cabinet";
                temp_theme = "三级文物";
                temp_content = "Gift of Eugene and Marian Gabrych.\n" +
                        "\n" +
                        "Dynasty:20th century\n" +
                        "\n" +
                        "Type:Wood Cabinet\n" +
                        "\n" ;
            }else if (i == 9) {
                pic = R.mipmap.h9;
                temp_name = "Ceremonial Hatchet";
                temp_theme = "二级文物";
                temp_content = "Museum purchase with funds provided by Anne R. and Amy Putnam.\n" +
                        "Dynasty:14th century BCE-11th century BCE\n" +
                        "Type:Jade Hatchet\n" ;
            }else if (i == 10) {
                pic = R.mipmap.h10;
                temp_name = "Covered Box for Chip Incense";
                temp_theme = "二级文物";
                temp_content = "Gift of Mrs. Alfred Machris.\n" +
                        "Dynasty:early 20th century\n" +
                        "Type:Jade Box\n" ;
            }
//            else if (i == 10) {
//                pic = R.mipmap.h6;
//                temp_name = "将进酒";
//                temp_theme = "二级文物";
//                temp_content = "";
//            }

            GSBean bean = new GSBean();
            bean.ids = System.currentTimeMillis() + "";

            bean.pic = pic;
            bean.name = temp_name;
            bean.theme = temp_theme;
            bean.content = temp_content;
            bean.save();
        }
    }

    @OnClick({  R.id.tv_shoucang, R.id.tv_fenxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {


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
                    ToastUtil.showToast(getActivity(), "收藏成功");
//                    onBackPressed();
                    initData();
                } else {
                    ToastUtil.showToast(getActivity(), "已收藏，无需再次收藏");
                }
                break;
            case R.id.tv_fenxiang:
                ShareUtil.share(getActivity(), gsBean.content, gsBean.name, "https://www.toutiao.com/a6902226785228915211/?channel=&source=search_tab", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.puchedu.cn%2Fuploads%2F3%2F26%2F251294644%2F174425602.jpg&refer=http%3A%2F%2Fimg.puchedu.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640846328&t=d7399d80c439e58d2973d15cb001a401", 0, new I_OnShareCallBack() {
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }

}
