package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.LoginActivity;
import com.bw.movie.WeiDuMovie.activity.MyFollowActivity;
import com.bw.movie.WeiDuMovie.activity.MyLatesteditionActivity;
import com.bw.movie.WeiDuMovie.activity.MyMessageActivity;
import com.bw.movie.WeiDuMovie.activity.MyRecordActivity;
import com.bw.movie.WeiDuMovie.activity.MyfeedbackActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class MyFragmentPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_head;
    private RelativeLayout my_message;
    private RelativeLayout my_follow;
    private RelativeLayout my_record;
    private RelativeLayout my_feedback;
    private RelativeLayout my_Latestedition;

    @Override
    public int getLayoutId() {
        return R.layout.my_fragmen;
    }

    @Override
    public void initData() {
        super.initData();
        image_head = get(R.id.image_head);
        my_message = get(R.id.my_message);
        my_follow = get(R.id.my_follow);
        my_record = get(R.id.my_record);
        my_Latestedition = get(R.id.my_Latestedition);
        my_feedback = get(R.id.my_feedback);
        setOnClikLisener(this,
                R.id.my_follow,
                R.id.my_feedback,
                R.id.my_Latestedition,
                R.id.my_message,
                R.id.image_head,
                R.id.my_record);
    }


    private  Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击头像进行登录
            case R.id.image_head:
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                break;
                //我的信息
            case R.id.my_message:
                Intent messageintent = new Intent(context, MyMessageActivity.class);
                context.startActivity(messageintent);
                break;
                //我的关注
            case R.id.my_follow:
                Intent follow = new Intent(context, MyFollowActivity.class);
                context.startActivity(follow);
                break;
                //购票记录
            case R.id.my_record:
                Intent record = new Intent(context, MyRecordActivity.class);
                context.startActivity(record);
                break;
                //意见反馈
            case R.id.my_feedback:
                Intent feedback = new Intent(context, MyfeedbackActivity.class);
                context.startActivity(feedback);
                break;
                //最新版本
            case R.id.my_Latestedition:
                Intent Latestedition = new Intent(context, MyLatesteditionActivity.class);
                context.startActivity(Latestedition);
                break;

        }
    }
}
