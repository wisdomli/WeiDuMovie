package com.bw.movie.WeiDuMovie.activity;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.WeiDuMovie.presenter.TicketDetailsActivityPresenter;

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
