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
import com.bw.movie.WeiDuMovie.aestoolkit.EncryptUtil;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class RegActivityPresenter extends AppDelegate implements View.OnClickListener {
    private Map<String, String> map = new HashMap<>();
    private EditText my_user_name, my_user_sex, my_user_data, my_user_phonenumber, my_user_email, my_user_pwd;
    private int sexs;

    private RelativeLayout Reg_btn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void initData() {
        super.initData();
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
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
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
                String pwd = my_user_pwd.getText().toString();
                // 进行密码加密
                String pwds = EncryptUtil.encrypt(pwd);
                String name = my_user_name.getText().toString();
                String sex = my_user_sex.getText().toString();
                if ("男".equals(sex)) {
                    sexs = 1;
                } else if ("女".equals(sex)) {
                    sexs =2;
                }
                String data = my_user_data.getText().toString();
                String phonenumber = my_user_phonenumber.getText().toString();
                String email = my_user_email.getText().toString();

                map.put("nickName", name);
                map.put("phone", phonenumber);
                map.put("pwd", pwds);
                map.put("pwd2", pwds);
                map.put("sex", ""+sexs);
                map.put("birthday", data);
                map.put("os", "android");
                map.put("email", email);
                postString(0, HttpUrl.RegisterUrl, map);
                break;
        }
    }
}
