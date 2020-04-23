package com.aaron.mymvp.base;

import android.content.Context;

/**
 * View接口中定义Activity的UI逻辑。因为有很多方法几乎在每个Activity中都会用到，
 * 例如显示和隐藏正在加载进度条，显示Toast提示等，索性将这些方法变成通用的
 */
public interface IBaseView {
    /**
     * 显示正在加载view
     */
    void showLoading();

    /**
     * 关闭正在加载view
     */
    void hideLoading();

    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showErr();

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
