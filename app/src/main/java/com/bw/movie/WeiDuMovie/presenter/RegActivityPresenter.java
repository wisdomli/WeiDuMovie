package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

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
public class RegActivityPresenter extends AppDelegate {
    private Map<String,String> map = new HashMap<>();
    private String name;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void initData() {
        super.initData();
      EditText my_user_name= get(R.id.my_user_name);
      EditText my_user_sex= get(R.id.my_user_sex);
      EditText my_user_data= get(R.id.my_user_data);
      EditText my_user_phonenumber= get(R.id.my_user_phonenumber);
      EditText my_user_email= get(R.id.my_user_email);
      EditText  my_user_pwd =get(R.id.my_user_pwd);
      // 获取输入
        String pwd = my_user_pwd.getText().toString();
        // 进行密码加密
        String pwds = EncryptUtil.encrypt(pwd);
        name = my_user_name.getText().toString().trim();
        String sex = my_user_sex.getText().toString().trim();
        String data = my_user_data.getText().toString().trim();
        String phonenumber = my_user_phonenumber.getText().toString().trim();
        String email = my_user_email.getText().toString().trim();
        

        map.put("nickName","顾梓舒");
        map.put("phone","18533959663");
        map.put("pwd",pwds);
        map.put("pwd2",pwds);
        map.put("sex","1");
        map.put("birthday",data);
        map.put("os","android");
        map.put("email","1757601669@qq.com");

       RelativeLayout Reg_btn = get(R.id.Reg_btn);

        Reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postString(0, HttpUrl.RegisterUrl,map);
                Log.i("RegActivityPresenter",name);
            }
        });

    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Log.i("RegActivityPresenter",data);
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
