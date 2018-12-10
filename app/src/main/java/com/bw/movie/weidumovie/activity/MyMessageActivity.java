package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MyMessageActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/29
 */
public class MyMessageActivity extends BaseActivityPresenter<MyMessageActivityPresenter>{
    @Override
    public Class<MyMessageActivityPresenter> getClassDelegate() {
        return MyMessageActivityPresenter.class;
    }

    @Override
    protected void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
