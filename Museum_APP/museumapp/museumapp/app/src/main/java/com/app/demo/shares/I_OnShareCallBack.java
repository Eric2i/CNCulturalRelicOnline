package com.app.demo.shares;

/**
 * @类名称: CLASS
 * @类描述:
 * @创建人：大海
 * @创建时间：2019/5/30
 * @备注： 分享回调
 */

public abstract class I_OnShareCallBack {

    //分享结果  --某个渠道
    public abstract void onShareSuccess(String shareChannel);

    public abstract void onShareCancel(String shareChannel);

    public abstract void onShareError(String shareChannel);
}
