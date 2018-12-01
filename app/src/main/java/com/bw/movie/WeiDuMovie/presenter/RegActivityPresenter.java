package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
public class RegActivityPresenter extends AppDelegate implements View.OnClickListener {
    private Map<String, String> map = new HashMap<>();
    private EditText my_user_name, my_user_sex, my_user_data, my_user_phonenumber, my_user_email, my_user_pwd,repeat_pwd;
    private int sexs;

    private RelativeLayout Reg_btn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void initData() {
        super.initData();
        repeat_pwd = get(R.id.repeat_pwd);
        my_user_name = get(R.id.my_user_name);
        my_user_sex = get(R.id.my_user_sex);
        my_user_data = get(R.id.my_user_data);
        my_user_phonenumber = get(R.id.my_user_phonenumber);
        my_user_email = get(R.id.my_user_email);
        my_user_pwd = get(R.id.my_user_pwd);
        Reg_btn = get(R.id.Reg_btn);
        setOnClikLisener(this, R.id.Reg_btn);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        RegBean regBean = gson.fromJson(data, RegBean.class);
        String status = regBean.getStatus();
        String message = regBean.getMessage();
        if (status.equals("0000")){
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
            ((RegActivity)context).finish();
        }else {
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Reg_btn:
                // 获取输入
                String name = my_user_name.getText().toString().trim();
                String sex = my_user_sex.getText().toString().trim();
                if ("男".equals(sex)) {
                    sexs = 1;
                } else if ("女".equals(sex)) {
                    sexs =2;
                }
                String data = my_user_data.getText().toString().trim();
                String phonenumber = my_user_phonenumber.getText().toString().trim();
                String email = my_user_email.getText().toString().trim();
                String pwd = my_user_pwd.getText().toString().trim();
                String repeat_pwd = this.repeat_pwd.getText().toString();
                // 进行密码加密
                String password = EncryptUtil.encrypt(pwd);
                String repeat_password = EncryptUtil.encrypt(repeat_pwd);
                if (name.isEmpty()){
                    Toast.makeText(context,"请输入昵称",Toast.LENGTH_SHORT).show();
                }else if(sex.isEmpty()){
                    Toast.makeText(context,"请输入性别",Toast.LENGTH_SHORT).show();
                }else if (data.isEmpty()){
                    Toast.makeText(context,"请输入日期",Toast.LENGTH_SHORT).show();
                }else if (phonenumber.isEmpty()){
                    Toast.makeText(context,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty()){
                    Toast.makeText(context,"请输入邮箱",Toast.LENGTH_SHORT).show();
                }else if (pwd.isEmpty()){
                    Toast.makeText(context,"请输入登录密码",Toast.LENGTH_SHORT).show();
                }else if (repeat_pwd.isEmpty()){
                    Toast.makeText(context,"再次确认密码",Toast.LENGTH_SHORT).show();
                }else if(!name.isEmpty()&&!sex.isEmpty()&&!data.isEmpty()&&!phonenumber.isEmpty()&&!email.isEmpty()&&!pwd.isEmpty()&&!repeat_password.isEmpty()){
                    map.put("nickName", name);
                    map.put("phone", phonenumber);
                    map.put("pwd", password);
                    map.put("pwd2", repeat_password);
                    map.put("sex", ""+sexs);
                    map.put("birthday", data);
                    map.put("email", email);
                    postString(0, HttpUrl.RegisterUrl, map);
                }
                break;
        }
    }
}
