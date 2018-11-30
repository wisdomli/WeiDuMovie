package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyLatesteditionActivityPresenter;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyLatesteditionActivity extends BaseActivityPresenter<MyLatesteditionActivityPresenter>{
    @Override
    public Class<MyLatesteditionActivityPresenter> getClassDelegate() {
        return MyLatesteditionActivityPresenter.class;
    }
}
