package com.app.demo;

import android.app.Application;

import com.app.utils.AppDir;
import com.app.utils.FrescoUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import org.litepal.LitePal;

/**
 * @anthor : 大海
 * 每天进步一点点
 */


public class MyApplication extends Application {

    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        if (instance != null) {
            //数据库初始化
            LitePal.initialize(instance);

            //创建应用缓存路径
            AppDir.getInstance(this);

            //fresco初始化
            FrescoUtil.init(instance);

            initFenxiang();
        }
    }


    public void   initFenxiang() {
        //友盟
        UMConfigure.init(this, "5ebcae28dbc2ec07f77a0536", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");

        //参数1:微信；参数2：微信
        //注：植入其他项目中时，直接在微信开发者更换包名即可:482f87363c68cdae5ab8c8f14326cfbd
        PlatformConfig.setWeixin("wxa7974d581a6cef99", "482f87363c68cdae5ab8c8f14326cfbd");

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
    }
}
