package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MyMessageActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/29
 */
public class MyMessageActivityPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_back;
    private TextView phone;
    private TextView back_login;
    private TextView nickName_name;
    private TextView my_sex;
    private TextView my_email;
    private TextView my_birthday;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @Override
    public void initData() {
        super.initData();
        back_login = get(R.id.back_login);
        image_back = get(R.id.image_back);
        nickName_name = get(R.id.nickName);
        my_email = get(R.id.my_email);
        my_birthday = get(R.id.my_birthday);
        my_sex = get(R.id.my_sex);
        phone = get(R.id.phone);
        setOnClikLisener(this,R.id.image_back);
        setOnClikLisener(this,R.id.back_login);
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
            case R.id.image_back:
                ((MyMessageActivity) context).finish();
                break;
            case R.id.back_login:
                boolean success = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success == true){
                    Toast.makeText(context,"退出成功",Toast.LENGTH_SHORT).show();
                    context.getSharedPreferences("config",0).edit().clear().commit();
                    ((MyMessageActivity)context).finish();
                }else {
                    Toast.makeText(context,"您还没有登录",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public void onResume() {
        String name = context.getSharedPreferences("config", 0).getString("phone", "").toString();
        String email = context.getSharedPreferences("config", 0).getString("email", "").toString();
        String nickName = context.getSharedPreferences("config", 0).getString("nickName", "").toString();
        int sex = context.getSharedPreferences("config", 0).getInt("sex", 0);
        long birthday = context.getSharedPreferences("config", 0).getLong("birthday", 0);
        //获取生日
        if (birthday!=0){
            my_birthday.setText("");
        }else {
            my_birthday.setText(birthday+"");
        }
        //获取性别
        if (sex!=0){
            my_sex.setText("");
        }else {
            my_sex.setText(sex);
        }
        //获取邮箱
        if (email.isEmpty()){
            my_email.setText("");
        }else {
            my_email.setText(email);
        }
        //获取用户名
        if (nickName.isEmpty()){
            nickName_name.setText("");
        }else {
            nickName_name.setText(nickName);
        }
        //获取手机号
        if (name.isEmpty()){
            phone.setText("");
        }else {
            phone.setText(name);
        }
    }
}
