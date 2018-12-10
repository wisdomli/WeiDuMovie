package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MyfeedbackActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyfeedbackActivity extends BaseActivityPresenter<MyfeedbackActivityPresenter>{
    @Override
    public Class<MyfeedbackActivityPresenter> getClassDelegate() {
        return MyfeedbackActivityPresenter.class;
    }
}
