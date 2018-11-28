package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.RegActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class LoginActivityPresenter extends AppDelegate implements View.OnClickListener {

    private EditText my_phone;
    private TextView text_reg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        super.initData();
        //取消edittext光标
        my_phone = get(R.id.my_phone);
        my_phone.setCursorVisible(false);
        text_reg = get(R.id.text_reg);
        //点击进入注册页面
        setOnClikLisener(this,R.id.text_reg);
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_reg:
                Intent intent = new Intent(context, RegActivity.class);
                context.startActivity(intent);
                break;
        }
    }
}
