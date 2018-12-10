package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.FilmFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class FilmFragment extends BaseFragmentPresenter<FilmFragmentPresenter> {
    @Override
    public Class<FilmFragmentPresenter> getClassDelegate() {
        return FilmFragmentPresenter.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
