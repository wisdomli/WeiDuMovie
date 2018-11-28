package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class RegActivityPresenter extends AppDelegate {
    @Override
    public int getLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void initData() {
        super.initData();
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
