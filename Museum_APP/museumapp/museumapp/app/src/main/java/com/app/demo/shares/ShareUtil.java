package com.app.demo.shares;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * 修改分享工具类
 */

public class ShareUtil {
    private static SHARE_MEDIA[] shareDisplaylist;


    /**
     * @param msg      分享内容
     * @param title    分享标题
     * @param url      分享的url
     * @param activity 上下文
     */
    public static void share(final Activity activity,
                              String msg,
                              String title,
                              String url,
                              String thumb,
                              int shareResultType,
                              I_OnShareCallBack i_onShareCallBack) {

        shareDisplaylist = new SHARE_MEDIA[]{SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE};

        /**android 6.0 权限申请*/
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //请求权限
                String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
                ActivityCompat.requestPermissions(activity, mPermissionList, 123);
            } else {
                shareReal(activity, msg, title, url, thumb, shareDisplaylist, shareResultType, i_onShareCallBack);
            }
        }
    }

    private static void shareReal(final Activity activity,
                                  final String msg,   //描述
                                  final String title, //分享标题
                                  String url,   //分享的链接
                                  String thumb,   //缩略图
                                  SHARE_MEDIA[] displaylist,    //分享的渠道
                                  final int callBackType,//回调类型：0：默认回调；1：点击面板回调
                                  final I_OnShareCallBack i_onShareCallBack //分享的回调
    ) {

        //自定义分享面板
        new ShareWindowView.Builder()
                .setShareMsg(msg)
                .setShareTitle(title)
                .setShareUrl(url)
                .setThumb(thumb)
                .setShareIsBlock(callBackType)
                .setShareActivity(activity)
                .setData(displaylist)
                .setShareIonShareCallBack(i_onShareCallBack)
                .build().show(activity.getFragmentManager());
    }


}
