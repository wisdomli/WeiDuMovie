package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.Fragment02Presenter;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class Fragment02 extends BaseFragmentPresenter<Fragment02Presenter>{
    @Override
    public Class<Fragment02Presenter> getClassDelegate() {
        return Fragment02Presenter.class;
    }
}
