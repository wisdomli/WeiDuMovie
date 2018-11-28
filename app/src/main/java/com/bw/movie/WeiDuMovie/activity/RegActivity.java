package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.RegActivityPresenter;

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
