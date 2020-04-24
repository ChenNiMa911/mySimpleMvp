package com.aaron.mymvp.base.model;

/**
 * 所有Model的顶级父类，
 * 负责对外提供数据请求标准，对内为所有Model提供请求的底层支持。
 */

import com.aaron.mymvp.base.IMvpCallback;

import java.util.Map;

/**
 * BaseModel中定义了对外的请求数据规则，
 * 包括设置参数的方法和设置Callback的方法，
 * 还可以定义一些通用的数据请求方法，比如说网络请求的Get和Post方法。
 */
public abstract class BaseModel<T> {
    //数据请求参数
    protected String[] mParams;
    /**
     * 设置数据请求参数
     * @param args 参数数组
     */
    public  BaseModel params(String... args){
        mParams = args;
        return this;
    }
    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(IMvpCallback<T> callback);
    // 执行Get网络请求，此类看需求由自己选择写与不写
    protected void requestGetAPI(String url,IMvpCallback<T> callback){
        //这里写具体的网络请求
    }
    // 执行Post网络请求，此类看需求由自己选择写与不写
    protected void requestPostAPI(String url, Map params, IMvpCallback<T> callback){
        //这里写具体的网络请求
    }
}
