package com.bw.movie.weidumovie.activity;

import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.TicketDetailsActivityPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/12/5
 **/
public class TicketDetailsActivity extends BaseActivityPresenter<TicketDetailsActivityPresenter> {
    @Override
    public Class<TicketDetailsActivityPresenter> getClassDelegate() {
        return TicketDetailsActivityPresenter.class;
    }
}
