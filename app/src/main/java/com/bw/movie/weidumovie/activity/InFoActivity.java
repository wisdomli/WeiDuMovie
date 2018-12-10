package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.InFoActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/12/5
 */
public class InFoActivity extends BaseActivityPresenter<InFoActivityPresenter>{
    @Override
    public Class<InFoActivityPresenter> getClassDelegate() {
        return InFoActivityPresenter.class;
    }
}
