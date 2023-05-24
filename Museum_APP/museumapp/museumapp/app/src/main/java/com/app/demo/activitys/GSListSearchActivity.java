package com.app.demo.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.demo.R;
import com.app.demo.beans.GSBean;
import com.app.utils.GlideUtils;
import com.app.utils.StringUtil;
import com.app.utils.ToastUtil;
import com.app.utils.UserManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class GSListSearchActivity extends BaseActivity {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.bt_search)
    Button btSearch;
    @BindView(R.id.banner)
    Banner banner;

    List<GSBean> list_shici = new ArrayList<>();
    MyAdapter adapter;

    String stype;
    String user_id;
    String str_sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_list_search);
        ButterKnife.bind(this);

        user_id = UserManager.getUserId(this);
        stype = getIntent().getStringExtra("stype");
        tvTitle.setText("专题(" + stype + ")列表");
        initData();
        initBanner();
    }

    private void initData() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (StringUtil.isEmpty(edtSearch.getText().toString().trim())) {
                    ToastUtil.showToast(GSListSearchActivity.this, "搜索内容不能为空");
                    return;
                }
                EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
            }
        });

        //排列方式
        recy.setLayoutManager( new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        recy.setLayoutManager(new LinearLayoutManager(GSListSearchActivity.this));

        adapter = new MyAdapter(R.layout.item_gs, list_shici);
        adapter.setEmptyView(LayoutInflater.from(GSListSearchActivity.this).inflate(R.layout.view_list_empty, null));
        recy.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(GSListSearchActivity.this, GSDetailActivity.class);
                intent.putExtra("bean", list_shici.get(position));
                startActivity(intent);
            }
        });
        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
    }

    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.Refresh) {
            List<GSBean> temp2 = DataSupport.findAll(GSBean.class);
            list_shici.clear();
            str_sel = edtSearch.getText().toString().trim();
            if (StringUtil.isEmpty(str_sel)) {
                for (int i = 0; i < temp2.size(); i++) {
                    if (temp2.get(i).theme.contains(stype)) {
                        list_shici.add(temp2.get(i));
                    }
                }
            } else {
                for (int i = 0; i < temp2.size(); i++) {
                    if (temp2.get(i).name.contains(str_sel) && temp2.get(i).theme.contains(stype)) {
                        list_shici.add(temp2.get(i));
                    }
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    class MyAdapter extends BaseQuickAdapter<GSBean, MyAdapter.ViewHolder> {


        public MyAdapter(int layout, @Nullable List<GSBean> data) {
            super(layout, data);

        }


        @Override
        protected void convert(ViewHolder holder, GSBean bean) {
            holder.tv_name.setText(bean.name);

            holder.iv_pic.setImageResource(bean.pic);

        }

        public class ViewHolder extends BaseViewHolder {
            TextView tv_name;
            ImageView iv_pic;


            public ViewHolder(View view) {
                super(view);
                tv_name = view.findViewById(R.id.tv_name);

                iv_pic = view.findViewById(R.id.iv_pic);
            }
        }

    }

    /**
     * 轮播图
     */
    private void initBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new FresscoImageLoader());
        //设置banner动画效果
//        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置允许手势滑动
        banner.setViewPagerIsScroll(true);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        List list_banner = new ArrayList();
        list_banner.add("https://p5.itc.cn/q_70/images03/20230513/2baa1f4662424304a557b41202fe405c.jpeg");
        list_banner.add("https://p8.itc.cn/q_70/images03/20230513/d513dd4b4b894c46bb2240ffa6b9d561.jpeg");
        list_banner.add("https://p8.itc.cn/q_70/images03/20230513/debb5a00c2cd469aa6e401d84b6b4331.jpeg");

        banner.setImages(list_banner);

        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }


    public class FresscoImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            String url = (String) path;
            GlideUtils.getInstance().loadImage(GSListSearchActivity.this, url, imageView);
        }

        //提供createImageView 方法，方便fresco自定义ImageView
        @Override
        public ImageView createImageView(Context context) {

            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) getLayoutInflater().inflate(R.layout.layout_banner_imageview, null);
//            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            return simpleDraweeView;
        }
    }


    @OnClick({R.id.imgv_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;

        }
    }
}
