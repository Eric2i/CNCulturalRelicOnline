package com.app.demo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.demo.R;
import com.app.demo.beans.GSRecordBean;
import com.app.demo.beans.GSShoucangBean;
import com.app.utils.UserManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class GSLiulanListActivity extends BaseActivity {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.tv_title)
    TextView tvTitle;


    List<GSRecordBean> list_cuo = new ArrayList<>();
    MyAdapter adapter;


    String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_liulan_list);
        ButterKnife.bind(this);
        tvTitle.setText("浏览记录");
        user_id = UserManager.getUserId(this);

        initData();

    }

    private void initData() {
        recy.setLayoutManager(new LinearLayoutManager(GSLiulanListActivity.this));
        adapter = new MyAdapter(R.layout.item_gs_record, list_cuo);
        adapter.setEmptyView(LayoutInflater.from(GSLiulanListActivity.this).inflate(R.layout.view_list_empty, null));
        recy.setAdapter(adapter);


        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
    }
    @OnClick({R.id.imgv_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;


        }
    }
    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.Refresh) {
            List<GSRecordBean> temp2 = DataSupport.findAll(GSRecordBean.class);
            list_cuo.clear();
            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i).userId.equals(user_id)) {
                    list_cuo.add(temp2.get(i));
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    class MyAdapter extends BaseQuickAdapter<GSRecordBean, MyAdapter.ViewHolder> {


        public MyAdapter(int layout, @Nullable List<GSRecordBean> data) {
            super(layout, data);

        }


        @Override
        protected void convert(ViewHolder holder, GSRecordBean bean) {
            holder.tv_name.setText(bean.name);
            holder.tv_theme.setText(bean.theme);
            holder.tv_time.setText(bean.sc_id);
            holder.iv_pic.setImageResource(bean.pic);

        }

        public class ViewHolder extends BaseViewHolder {
            TextView tv_name;
            ImageView iv_pic;
            TextView tv_theme;
            TextView tv_time;

            public ViewHolder(View view) {
                super(view);
                tv_name = view.findViewById(R.id.tv_name);
                tv_theme = view.findViewById(R.id.tv_theme);
                tv_time = view.findViewById(R.id.tv_time);
                iv_pic = view.findViewById(R.id.iv_pic);
            }
        }

    }

}
