package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.FeedbacksuccessActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/12/1
 */
public class FeedbacksuccessActivityPresenter extends AppDelegate{

    private ImageView image_back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback_success;
    }

    @Override
    public void initData() {
        super.initData();
        image_back = get(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FeedbacksuccessActivity)context).finish();
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
