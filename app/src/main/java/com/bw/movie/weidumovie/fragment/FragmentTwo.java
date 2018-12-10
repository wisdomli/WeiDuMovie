package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.Fragment02Presenter;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class FragmentTwo extends BaseFragmentPresenter<Fragment02Presenter>{
    @Override
    public Class<Fragment02Presenter> getClassDelegate() {
        return Fragment02Presenter.class;
    }
}
