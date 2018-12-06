package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.InFoActivityPresenter;

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
