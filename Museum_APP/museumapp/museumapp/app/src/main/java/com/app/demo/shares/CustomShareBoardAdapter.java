package com.app.demo.shares;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.app.demo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;

/**
 * @类名称: CLASS
 * @类描述:
 * @创建人：大海
 * @备注：友盟分享自定义面板适配器
 */
public class CustomShareBoardAdapter extends BaseQuickAdapter<SHARE_MEDIA, CustomShareBoardAdapter.ViewHolder> {


    Context context;

    public CustomShareBoardAdapter(Context context, int layoutResId, @Nullable List data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder helper, SHARE_MEDIA item) {

        switch (item.toString()) {

            case "WEIXIN":
                helper.tv_custom_umeng_channel.setText("微信好友");
                helper.imgv_custom_umeng_channel.setImageResource(R.drawable.umeng_socialize_wechat);
                break;
            case "WEIXIN_CIRCLE":
                helper.tv_custom_umeng_channel.setText("朋友圈");
                helper.imgv_custom_umeng_channel.setImageResource(R.drawable.umeng_socialize_wxcircle);
                break;
        }
    }

    public class ViewHolder extends BaseViewHolder {
        TextView tv_custom_umeng_channel;
        ImageView imgv_custom_umeng_channel;
        LinearLayout ll;

        public ViewHolder(View view) {
            super(view);
            tv_custom_umeng_channel = view.findViewById(R.id.tv_custom_umeng_channel);
            imgv_custom_umeng_channel = view.findViewById(R.id.imgv_share_umeng_channel);
            ll = view.findViewById(R.id.ll);
        }
    }

}
