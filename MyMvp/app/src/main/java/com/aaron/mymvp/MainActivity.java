package com.aaron.mymvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements IMvpView {

    MvpPresenter mvpPresenter;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);

        //初始化Presenter
        mvpPresenter = new MvpPresenter();
        // 绑定View引用
        mvpPresenter.attachView(this);
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }
    // button 点击事件调用方法
    public void getData(View view){
        mvpPresenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        mvpPresenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        mvpPresenter.getData("error");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        mvpPresenter.detachView();
    }
}
