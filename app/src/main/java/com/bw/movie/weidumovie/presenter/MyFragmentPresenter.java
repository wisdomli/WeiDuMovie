package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.LoginActivity;
import com.bw.movie.weidumovie.activity.MyFollowActivity;
import com.bw.movie.weidumovie.activity.MyMessageActivity;
import com.bw.movie.weidumovie.activity.MyRecordActivity;
import com.bw.movie.weidumovie.activity.MyfeedbackActivity;
import com.bw.movie.weidumovie.activity.MyversionActivity;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class MyFragmentPresenter extends AppDelegate implements View.OnClickListener {

    private SimpleDraweeView image_head;
    private RelativeLayout my_message;
    private ImageView follow;
    private ImageView my_record;
    private ImageView feedback;
    private ImageView version;
    private TextView user;
    private boolean success;

    @Override
    public int getLayoutId() {
        return R.layout.my_fragmen;
    }

    @Override
    public void initData() {
        super.initData();
        image_head = get(R.id.image_head);
        my_message = get(R.id.my_message);
        my_record = get(R.id.my_record);
        user = get(R.id.user);
        follow = get(R.id.follow);
        feedback = get(R.id.feedback);
        version = get(R.id.version);

        setOnClikLisener(this,
                R.id.my_message,
                R.id.image_head,
                R.id.follow,
                R.id.my_record,
                R.id.feedback,
                R.id.version);

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
            //点击头像进行登录
            case R.id.image_head:
                //判断是否登录 登录进入信息界面 不登陆进入登录页面
                boolean success_lo = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success_lo==true){
                    Intent messageintent = new Intent(context, MyMessageActivity.class);

                    context.startActivity(messageintent);
                }else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
                break;
            //我的信息
            case R.id.my_message:
                success = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success ==true){
                    Intent messageintent = new Intent(context, MyMessageActivity.class);
                    context.startActivity(messageintent);
                }else {
                    Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            //我的关注
            case R.id.follow:
                boolean success1 = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success1 ==true){
                    Intent follow = new Intent(context, MyFollowActivity.class);
                    context.startActivity(follow);
                }else {
                    Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            //我的记录
            case R.id.my_record:
                boolean success2 = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success2 ==true){
                    Intent my_record = new Intent(context, MyRecordActivity.class);
                    context.startActivity(my_record);
                }else {
                    Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            //意见反馈
            case R.id.feedback:
                boolean success3 = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success3 ==true){
                    Intent feedback = new Intent(context, MyfeedbackActivity.class);
                    context.startActivity(feedback);
                }else {
                    Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
            //最新版本
            case R.id.version:
                boolean success4 = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success4 ==true){
                    Intent version = new Intent(context, MyversionActivity.class);
                    context.startActivity(version);
                }else {
                    Toast.makeText(context,"请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onResume() {
        String headPic = context.getSharedPreferences("config", 0).getString("headPic", "").toString();
        String nickName = context.getSharedPreferences("config", 0).getString("nickName", "").toString();
        boolean success_lo = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
        if (success_lo==true){
            image_head.setImageURI(headPic);
        }else {
            image_head.setImageURI("res:// /"+R.drawable.touxiang);
        }
        //获取用户名
        if (nickName.isEmpty()){
            user.setText("");
        }else {
            user.setText(nickName);
        }
    }

}
