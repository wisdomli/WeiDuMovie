package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.UpdateUserActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/12/2
 */
public class UpdateUserActivity extends BaseActivityPresenter<UpdateUserActivityPresenter>{
    @Override
    public Class<UpdateUserActivityPresenter> getClassDelegate() {
        return UpdateUserActivityPresenter.class;
    }

    @Override
    protected void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
