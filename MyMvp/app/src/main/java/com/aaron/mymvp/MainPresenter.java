package com.aaron.mymvp;

// Presenter类是具体的逻辑业务处理类，
// 该类为纯Java类，不包含任何Android API，负责请求数据，并对数据请求的反馈进行处理。
//Presenter类的构造方法中有一个View接口的参数，
// 是为了能够通过View接口通知Activity进行更新界面等操作。

import com.aaron.mymvp.base.BasePresenter;
import com.aaron.mymvp.base.IMvpCallback;
import com.aaron.mymvp.base.model.DataModel;

/**
 * 之前是在Presenter的构造方法中得到View接口的引用，
 * 现在我们需要修改Presenter引用View接口的方式让View接口与宿主Activity共存亡
 * attachView() 绑定View引用。
 * detachView 断开View引用。
 * isViewAttached() 判断View引用是否存在。
 * 其中attachView()和detachView()是为Activity准备的，
 * isViewAttached()作用是Presenter内部每次调用View接口中的方法是判断View 的引用是否存在。
 */

public class MainPresenter extends BasePresenter<IMvpView> {

    public void getData(String param){
        if (!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }
        // 显示正在加载进度条
        getView().showLoading();
        // 调用Model请求数据
        DataModel
                // 设置请求标识token
                .request(MainModel.class)
                // 添加请求参数，没有则不添加
                .params(param)
                .execute(new IMvpCallback() {
                    @Override
                    public void onSuccess(Object data) {
                        //调用view接口显示数据
                        getView().showData(data.toString());
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        getView().showToast(msg);
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        getView().showErr();
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        getView().hideLoading();
                    }
                });
    }

}
