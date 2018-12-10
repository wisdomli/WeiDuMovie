package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.FilmDetailsActivityPresenter;

import cn.jzvd.Jzvd;


/**
 * 作者:李自强
 * <p>
 * 2018/12/2
 **/
public class FilmDetailsActivity extends BaseActivityPresenter<FilmDetailsActivityPresenter> {
    @Override
    public Class<FilmDetailsActivityPresenter> getClassDelegate() {
        return FilmDetailsActivityPresenter.class;
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

}
