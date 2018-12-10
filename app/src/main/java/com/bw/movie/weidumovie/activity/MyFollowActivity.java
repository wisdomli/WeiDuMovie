package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MyFollowActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyFollowActivity extends BaseActivityPresenter<MyFollowActivityPresenter>{
    @Override
    public Class<MyFollowActivityPresenter> getClassDelegate() {
        return MyFollowActivityPresenter.class;
    }
}
