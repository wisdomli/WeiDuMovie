package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.CinemaFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class CinemaFragment extends BaseFragmentPresenter<CinemaFragmentPresenter> {
    @Override
    public Class<CinemaFragmentPresenter> getClassDelegate() {
        return CinemaFragmentPresenter.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
