package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.MovieTicketActivityPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/12/6
 **/
public class MovieTicketActivity extends BaseActivityPresenter<MovieTicketActivityPresenter>{
    @Override
    public Class<MovieTicketActivityPresenter> getClassDelegate() {
        return MovieTicketActivityPresenter.class;
    }
}
