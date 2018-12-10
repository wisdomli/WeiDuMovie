package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.RegActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class RegActivity extends BaseActivityPresenter<RegActivityPresenter>{
    @Override
    public Class<RegActivityPresenter> getClassDelegate() {
        return RegActivityPresenter.class;
    }
}
