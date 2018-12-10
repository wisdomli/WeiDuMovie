package com.bw.movie.weidumovie.activity;

import android.support.annotation.NonNull;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MyRecordActivityPresenter;

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
