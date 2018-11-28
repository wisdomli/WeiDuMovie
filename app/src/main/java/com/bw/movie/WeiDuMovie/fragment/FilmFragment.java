package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.FilmFragmentPresenter;

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
}
