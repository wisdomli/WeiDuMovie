package com.bw.movie.WeiDuMovie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.WeiDuMovie.Immersive.UltimateBar;
import com.bw.movie.WeiDuMovie.R;

public class StartActivity extends AppCompatActivity {
private int i = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // 沉浸式
        UltimateBar.newImmersionBuilder()
                .applyNav(false)   // 是否应用到导航栏
                .build(this)
                .apply();
        // 发送消息进行3秒跳转
        handler.sendEmptyMessageDelayed(100,1000);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           if (msg.what == 100){
               // 让i减减
               i--;
               // 当等于0时直接跳转到主页面
              if (i == 0){
                  startActivity(new Intent(StartActivity.this,WelcomeActivity.class));
                  handler.removeMessages(100);
                  // 返回时直接销毁页面
                  finish();
              }else {
                // 否则, 继续发送消息
                  handler.sendEmptyMessageDelayed(100,1000);
              }
           }
        }
    };
}
