package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.LoginActivity;
import com.bw.movie.WeiDuMovie.activity.RegActivity;
import com.bw.movie.WeiDuMovie.aestoolkit.EncryptUtil;
import com.bw.movie.WeiDuMovie.bean.LoginBean;
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
    private LoginBean logBean;
    private ImageView eyepassword;

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
        eyepassword = get(R.id.eyepassword);
        hashMap = new HashMap<>();
        setOnClikLisener(this,R.id.login_lg);
        //点击进入注册页面
        setOnClikLisener(this,R.id.text_reg);
        setOnClikLisener(this,R.id.eyepassword);
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
        logBean = gson.fromJson(data, LoginBean.class);
        String status = logBean.getStatus();
        String message = logBean.getMessage();
        if (status.equals("0000")){

            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

            context.getSharedPreferences("config",0).edit()
                    .putString("nickName",logBean.getResult().getUserInfo().getNickName())
                    .putInt("sex",logBean.getResult().getUserInfo().getSex())
                    .putString("phone",logBean.getResult().getUserInfo().getPhone())
                    .putString("sessionId",logBean.getResult().getSessionId())
                    .putInt("userId",logBean.getResult().getUserId())
                    .putBoolean("isLogin",true)
                    .commit();
            Log.i("LoginActivityPresenter",data);

            ((LoginActivity)context).finish();
        }else {
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void erorrString(String erorr) {
        super.erorrString(erorr);
        Toast.makeText(context,erorr,Toast.LENGTH_SHORT).show();
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
            case R.id.eyepassword:
                //显示与隐藏密码
                TransformationMethod type = login_password.getTransformationMethod();
                if (PasswordTransformationMethod.getInstance().equals(type)){
                    login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}
