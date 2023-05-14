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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.app.base.BaseActivity;
import com.app.beans.EventMessage;
import com.app.demo.R;
import com.app.demo.beans.GSShoucangBean;
import com.app.demo.shares.I_OnShareCallBack;
import com.app.demo.shares.ShareUtil;
import com.app.utils.ToastUtil;
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

public class GSShoucangListActivity extends BaseActivity {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.tv_title)
    TextView tvTitle;



    List<GSShoucangBean> list_cuo = new ArrayList<>();
    MyAdapter adapter;


    String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_shoucang_list);
        ButterKnife.bind(this);
        tvTitle.setText("我的收藏");
        user_id = UserManager.getUserId(this);

        initData();

    }

    private void initData() {
        //排列方式
        recy.setLayoutManager( new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        recy.setLayoutManager(new LinearLayoutManager(GSListSearchActivity.this));
        adapter = new MyAdapter(R.layout.item_gs, list_cuo);
        adapter.setEmptyView(LayoutInflater.from(GSShoucangListActivity.this).inflate(R.layout.view_list_empty, null));
        recy.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(GSShoucangListActivity.this, GSShoucangDetailActivity.class);
                intent.putExtra("bean", list_cuo.get(position));
                startActivity(intent);
            }
        });
        EventBus.getDefault().post(new EventMessage(EventMessage.Refresh));
    }

    @Override
    public void onEvent(EventMessage msg) {
        super.onEvent(msg);
        if (msg.getMessageType() == EventMessage.Refresh) {
            List<GSShoucangBean> temp2 = DataSupport.findAll(GSShoucangBean.class);
            list_cuo.clear();
            for (int i=0;i<temp2.size();i++){
                if (temp2.get(i).userId.equals(user_id)){
                    list_cuo.add(temp2.get(i));
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    class MyAdapter extends BaseQuickAdapter<GSShoucangBean, MyAdapter.ViewHolder> {


        public MyAdapter(int layout, @Nullable List<GSShoucangBean> data ) {
            super(layout, data);

        }




        @Override
        protected void convert(MyAdapter.ViewHolder holder, GSShoucangBean bean) {
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


    @OnClick({R.id.imgv_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgv_return:
                onBackPressed();
                break;


        }
    }

}
