package com.aaron.mymvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aaron.mymvp.base.BaseActivity;
import com.aaron.mymvp.base.BasePresenter;

public class MainActivity extends BaseActivity implements IMvpView {
    // 继承于BasePresenter
    MainPresenter mainPresenter;
    TextView text;

    @Override
    public BasePresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    public void initPresenter() {
        mainPresenter = new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }
    // button 点击事件调用方法
    public void getData(View view){
        mainPresenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        mainPresenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        mainPresenter.getData("error");
    }
}
