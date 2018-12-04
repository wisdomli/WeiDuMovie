package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.RecommendCinemaFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class RecommendCinemaFragment extends BaseFragmentPresenter<RecommendCinemaFragmentPresenter> {
    @Override
    public Class<RecommendCinemaFragmentPresenter> getClassDelegate() {
        return RecommendCinemaFragmentPresenter.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
