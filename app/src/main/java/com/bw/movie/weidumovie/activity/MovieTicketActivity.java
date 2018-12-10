package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MovieTicketActivityPresenter;

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
