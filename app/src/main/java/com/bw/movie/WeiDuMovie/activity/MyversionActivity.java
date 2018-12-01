package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyversionActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyversionActivity extends BaseActivityPresenter<MyversionActivityPresenter>{
    @Override
    public Class<MyversionActivityPresenter> getClassDelegate() {
        return MyversionActivityPresenter.class;
    }
}
