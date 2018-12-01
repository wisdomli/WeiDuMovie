package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MyFollowActivity;
import com.bw.movie.WeiDuMovie.activity.MyfeedbackActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyFollowActivityPresenter extends AppDelegate {

    private ImageView image_back_follow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_follow;
    }

    @Override
    public void initData() {
        super.initData();
        image_back_follow = get(R.id.image_back_follow);
        image_back_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyFollowActivity) context).finish();
            }
        });
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
