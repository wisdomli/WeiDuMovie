package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.LoginActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class MyFragmentPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_head;

    @Override
    public int getLayoutId() {
        return R.layout.my_fragmen;
    }

    @Override
    public void initData() {
        super.initData();
        image_head = get(R.id.image_head);
        setOnClikLisener(this,R.id.image_head);
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
            case R.id.image_head:
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                break;
        }
    }
}
