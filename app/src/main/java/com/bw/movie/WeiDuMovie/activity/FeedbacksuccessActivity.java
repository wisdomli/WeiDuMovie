package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.FeedbacksuccessActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyfeedbackActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/12/1
 */
public class FeedbacksuccessActivity extends BaseActivityPresenter<FeedbacksuccessActivityPresenter>{
    @Override
    public Class<FeedbacksuccessActivityPresenter> getClassDelegate() {
        return FeedbacksuccessActivityPresenter.class;
    }
}
