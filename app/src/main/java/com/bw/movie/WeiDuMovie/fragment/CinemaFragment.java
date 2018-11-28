package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.CinemaFragmentPresenter;

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
}
