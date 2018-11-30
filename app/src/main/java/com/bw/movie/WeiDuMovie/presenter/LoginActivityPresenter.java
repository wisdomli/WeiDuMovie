package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.RegActivity;
import com.bw.movie.WeiDuMovie.aestoolkit.EncryptUtil;
import com.bw.movie.WeiDuMovie.bean.RegBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class LoginActivityPresenter extends AppDelegate implements View.OnClickListener {

    private TextView text_reg;
    private EditText login_phone;
    private EditText login_password;
    private RelativeLayout login_lg;
    private Map<String, String> hashMap;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        super.initData();
        text_reg = get(R.id.text_reg);
        login_phone = get(R.id.login_phone);
        login_password = get(R.id.login_password);
        login_lg = get(R.id.login_lg);
        hashMap = new HashMap<>();
        setOnClikLisener(this,R.id.login_lg);
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
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        RegBean regBean = gson.fromJson(data, RegBean.class);
        String status = regBean.getStatus();
        String message = regBean.getMessage();
        if (("0000").equals(status)){
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_reg:
                Intent intent = new Intent(context, RegActivity.class);
                context.startActivity(intent);
                break;
            case R.id.login_lg:
                String login_name = login_phone.getText().toString().trim();
                String login_pwd = this.login_password.getText().toString().trim();
                String pwd = EncryptUtil.encrypt(login_pwd);
                hashMap.put("phone",login_name);
                hashMap.put("pwd",pwd);
                postString(0, HttpUrl.LoginUrl,hashMap);
                break;
        }
    }
}
