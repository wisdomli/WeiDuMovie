package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyFollowActivityPresenter;

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
