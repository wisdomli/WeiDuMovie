package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.FeedbacksuccessActivityPresenter;
import com.bw.movie.weidumovie.presenter.MyfeedbackActivityPresenter;

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
