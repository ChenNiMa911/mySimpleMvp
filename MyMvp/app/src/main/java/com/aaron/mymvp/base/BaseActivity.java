package com.aaron.mymvp.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.aaron.mymvp.R;

/**
 * BaseActivity主要是负责实现 BaseView 中通用的UI逻辑方法，
 * 如此这些通用的方法就不用每个Activity都要去实现一遍了
 */

/**
 * 每个activity我们都要去手动操作presenter与view的链接与断开操作
 * 优化的办法:
 * 每个activity都继承于BaseActivity，
 * 每个presenter都继承于BasePresenter，
 * 所以，我们只需要在BaseActivity中实现BasePresenter链接view的操作即可
 */
public abstract class BaseActivity extends Activity implements IBaseView {
    private ProgressDialog mProgressDialog;

    /**
     * 获取Presenter实例，子类实现
     */
    public abstract BasePresenter getPresenter();

    /**
     * 初始化Presenter的实例，子类实现
     */
    public abstract void initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        if (getPresenter() != null){
            getPresenter().attachView(this);
        }

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);

    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
