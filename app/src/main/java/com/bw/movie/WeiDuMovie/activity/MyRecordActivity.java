package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyRecordActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyRecordActivity extends BaseActivityPresenter<MyRecordActivityPresenter>{
    @Override
    public Class<MyRecordActivityPresenter> getClassDelegate() {
        return MyRecordActivityPresenter.class;
    }
}
