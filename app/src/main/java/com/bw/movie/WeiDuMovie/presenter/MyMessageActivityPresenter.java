package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MyMessageActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/29
 */
public class MyMessageActivityPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @Override
    public void initData() {
        super.initData();
        image_back = get(R.id.image_back);
        setOnClikLisener(this,R.id.image_back);
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
        }
    }
}
