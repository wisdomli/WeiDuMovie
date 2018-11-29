package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyMessageActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/29
 */
public class MyMessageActivity extends BaseActivityPresenter<MyMessageActivityPresenter>{
    @Override
    public Class<MyMessageActivityPresenter> getClassDelegate() {
        return MyMessageActivityPresenter.class;
    }
}
