package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.Fragment01Presenter;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class FragmentOne extends BaseFragmentPresenter<Fragment01Presenter>{
    @Override
    public Class<Fragment01Presenter> getClassDelegate() {
        return Fragment01Presenter.class;
    }
}
