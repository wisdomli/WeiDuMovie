package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.Fragment01Presenter;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class Fragment01 extends BaseFragmentPresenter<Fragment01Presenter>{
    @Override
    public Class<Fragment01Presenter> getClassDelegate() {
        return Fragment01Presenter.class;
    }
}
