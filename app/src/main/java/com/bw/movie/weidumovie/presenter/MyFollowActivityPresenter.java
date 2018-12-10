package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.MyFollowActivity;
import com.bw.movie.weidumovie.fragment.FragmentOne;
import com.bw.movie.weidumovie.fragment.FragmentTwo;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyFollowActivityPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_back_follow;
    private TextView my_Film;
    private TextView my_Cinema;
    private FrameLayout frame_layout;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragmentOne fragment01;
    private FragmentTwo fragment02;
    private FragmentManager fragmentManager1;
    private FragmentTransaction transaction1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_follow;
    }

    @Override
    public void initData() {
        super.initData();
        my_Film = get(R.id.my_Film);
        my_Cinema = get(R.id.my_Cinema);
        frame_layout = get(R.id.frame_layout);
        image_back_follow = get(R.id.image_back_follow);
        setOnClikLisener(this,R.id.my_Film);
        setOnClikLisener(this,R.id.my_Cinema);
        setOnClikLisener(this,R.id.image_back_follow);
        //设置默认显示第一个fragment数据
        fragmentManager = ((MyFollowActivity) context).getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment01 = new FragmentOne();
        transaction.replace(R.id.frame_layout, fragment01);
        transaction.commit();
        //默认选中第一个
        my_Film.setTextColor(Color.WHITE);
        my_Film.setBackgroundResource(R.drawable.cinema_btn);
        my_Cinema.setTextColor(Color.BLACK);
        my_Cinema.setBackgroundResource(R.drawable.cinema_btn_f);
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
            case R.id.image_back_follow:
                ((MyFollowActivity) context).finish();
                break;
            case R.id.my_Film:
                //默认选中状态下
                my_Film.setTextColor(Color.WHITE);
                my_Film.setBackgroundResource(R.drawable.cinema_btn);
                my_Cinema.setTextColor(Color.BLACK);
                my_Cinema.setBackgroundResource(R.drawable.cinema_btn_f);
                //fragment1
                fragmentManager = ((MyFollowActivity) context).getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                fragment01 = new FragmentOne();
                transaction.replace(R.id.frame_layout, fragment01);
                transaction.commit();
                break;
            case R.id.my_Cinema:
                //切换选中状态下
                my_Cinema.setTextColor(Color.WHITE);
                my_Cinema.setBackgroundResource(R.drawable.cinema_btn);
                my_Film.setTextColor(Color.BLACK);
                my_Film.setBackgroundResource(R.drawable.cinema_btn_f);
                //fragment2
                fragmentManager1 = ((MyFollowActivity) context).getSupportFragmentManager();
                transaction1 = fragmentManager1.beginTransaction();
                fragment02 = new FragmentTwo();
                transaction1.replace(R.id.frame_layout, fragment02);
                transaction1.commit();
                break;
        }
    }
}
