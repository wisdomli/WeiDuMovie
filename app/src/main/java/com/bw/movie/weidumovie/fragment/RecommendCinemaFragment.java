package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.RecommendCinemaFragmentPresenter;

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
