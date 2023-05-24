package com.app.demo.shares;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.demo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;


/**
 * @类名称: CLASS
 * @类描述:
 * @创建人：大海
 * @创建时间：2019/5/30
 * @备注： 友盟分享面板
 */
@SuppressLint("ValidFragment")
public class ShareWindowView extends DialogFragment {
    private RecyclerView recy_custom_umeng_shareboard;
    private ArrayList<SHARE_MEDIA> listmedia = new ArrayList<>();
    private String msg;
    private String title;
    private String url;
    private String imgUrl;
    private int isBlock;
    private int type; //1 分享bitmap 0 默认
    private Bitmap bitmap;
    private Activity activity;
    private I_OnShareCallBack i_onShareCallBack;
    private TextView ivShareClose;
    private long lastTime = 0L;
    CustomShareBoardAdapter adapter;

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
//        win.getAttributes().windowAnimations = R.style.CollectDialogAnimation;
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams params = win.getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.BOTTOM | Gravity.CENTER;
        win.setAttributes(params);


        this.getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                long now = System.currentTimeMillis();
                if (now - lastTime < 1000) {
                    return true;
                }
                lastTime = now;
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
    }


    @SuppressLint("ValidFragment")
    public ShareWindowView(Builder builder) {
        this.listmedia = builder.listmedia;
        this.msg = builder.msg;
        this.title = builder.title;
        this.url = builder.url;
        this.imgUrl = builder.thumb;
        this.type = builder.type;
        this.bitmap = builder.bitmap;
        this.isBlock = builder.isBlock;
        this.activity = builder.activity;
        this.i_onShareCallBack = builder.i_onShareCallBack;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = LayoutInflater.from(activity).inflate(R.layout.custom_umeng_share_board_layout, null);
        recy_custom_umeng_shareboard = layout.findViewById(R.id.recy_custom_umeng_shareboard);
        ivShareClose = layout.findViewById(R.id.tv_share_close);
        initUmengGridView();
        initListener();
        return layout;
    }

    //监听
    private void initListener() {
        ivShareClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //分享渠道点击
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                goToShare(position);
            }
        });
    }

    /**
     * 分享渠道面板  自定义
     */
    private void initUmengGridView() {
        adapter = new CustomShareBoardAdapter(activity, R.layout.custom_umeng_share_item, listmedia);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recy_custom_umeng_shareboard.setLayoutManager(gridLayoutManager);
        recy_custom_umeng_shareboard.setAdapter(adapter);
    }


    /**
     * 启动分享
     *
     * @param position
     */
    private void goToShare(int position) {
        ShareAction shareAction = new ShareAction(activity);
        shareAction.setPlatform(listmedia.get(position)); //分享渠道

        UMWeb web = new UMWeb(url);
        web.setTitle(title);//标题
        UMImage umImage = new UMImage(activity, imgUrl);
        umImage.compressFormat = Bitmap.CompressFormat.PNG;
        web.setThumb(umImage);  //缩略图
        web.setDescription(msg);//描述
        shareAction.withMedia(web);


        if (isBlock == 0) {//回调默认友盟分享回调
            shareAction.setCallback(new UMShareListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {
                    if (null != i_onShareCallBack) {
                        i_onShareCallBack.onShareSuccess(getChannelFromMedia(share_media));
                    }
                }

                @Override
                public void onResult(SHARE_MEDIA share_media) {
                    if (null != i_onShareCallBack) {
                        i_onShareCallBack.onShareSuccess(getChannelFromMedia(share_media));
                    }
                }

                @Override
                public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                    if (null != i_onShareCallBack) {
                        i_onShareCallBack.onShareError(getChannelFromMedia(share_media));
                    }
                }

                @Override
                public void onCancel(SHARE_MEDIA share_media) {
                    if (null != i_onShareCallBack) {
                        i_onShareCallBack.onShareCancel(getChannelFromMedia(share_media));
                    }
                }
            });
        } else if (isBlock == 1) {//点击面板回调
            if (null != i_onShareCallBack) {
                String shareChannel = getChannelFromMedia(listmedia.get(position));
                i_onShareCallBack.onShareSuccess(shareChannel);
            }
        }
        shareAction.share();
    }


    public void show(FragmentManager manager) {
        this.show(manager, "分享弹窗");
    }


    @Override
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismiss();
    }


    private static String getChannelFromMedia(SHARE_MEDIA share_media) {
        String shareChannel = "1";
        if (share_media.toString().equals("WEIXIN")) {
            shareChannel = "1";
        } else if (share_media.toString().equals("WEIXIN_CIRCLE")) {
            shareChannel = "2";
        } else {
            shareChannel = "1";
        }

        return shareChannel;
    }

    public static class Builder {
        private ArrayList<SHARE_MEDIA> listmedia = new ArrayList<>();
        private String msg;
        private String title;
        private String url;
        private String thumb;
        private Bitmap bitmap;
        private int type; //0默认  1 图片
        private int isBlock;
        private Activity activity;
        private I_OnShareCallBack i_onShareCallBack;


        public ShareWindowView.Builder setData(SHARE_MEDIA[] share_media) {
            for (int i = 0; i < share_media.length; i++) {
                listmedia.add(share_media[i]);
            }
            return this;
        }


        public ShareWindowView.Builder setShareMsg(String msg) {
            this.msg = msg;
            return this;

        }

        public ShareWindowView.Builder setType(int type) {
            this.type = type;
            return this;
        }

        public ShareWindowView.Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public ShareWindowView.Builder setShareUrl(String url) {
            this.url = url;
            return this;
        }

        public ShareWindowView.Builder setShareTitle(String title) {
            this.title = title;
            return this;
        }

        public ShareWindowView.Builder setThumb(String thumb) {
            this.thumb = thumb;
            return this;
        }


        public ShareWindowView.Builder setShareIsBlock(int isBlock) {
            this.isBlock = isBlock;
            return this;
        }

        public ShareWindowView.Builder setShareActivity(Activity activity) {
            this.activity = activity;
            return this;
        }


        public ShareWindowView.Builder setShareIonShareCallBack(I_OnShareCallBack i_onShareCallBack) {
            this.i_onShareCallBack = i_onShareCallBack;
            return this;
        }


        public ShareWindowView build() {
            return new ShareWindowView(this);
        }
    }
}