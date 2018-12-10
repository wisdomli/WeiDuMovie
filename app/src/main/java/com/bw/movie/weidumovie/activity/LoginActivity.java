package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.LoginActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/28
 */
public class LoginActivity extends BaseActivityPresenter<LoginActivityPresenter> {
    @Override
    public Class<LoginActivityPresenter> getClassDelegate() {
        return LoginActivityPresenter.class;
    }
}
