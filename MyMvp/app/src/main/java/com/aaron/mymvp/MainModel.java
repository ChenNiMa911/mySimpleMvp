package com.aaron.mymvp;

import android.os.Handler;

import com.aaron.mymvp.base.model.BaseModel;
import com.aaron.mymvp.base.IMvpCallback;

// Model 类中定了具体的网络请求操作。
// 为模拟真实的网络请求，利用postDelayed方法模拟耗时操作，通过判断请求参数反馈不同的请求状态：

/**
 * 实现具体的Model请求时必须要重写BaseModel的抽象方法execute
 */
public class MainModel extends BaseModel<String> {

    /**
     * 获取网络接口数据
     * @param callback
     */
    @Override
    public void execute(final IMvpCallback<String> callback) {
        // 模拟网络请求耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mParams 是从父类得到的请求参数
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }
}
