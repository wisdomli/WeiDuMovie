package com.bw.movie.weidumovie.presenter;

import android.content.Context;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/12/6
 **/
public class MovieTicketActivityPresenter extends AppDelegate{
    @Override
    public int getLayoutId() {
        return R.layout.ticketdetails;
    }

    @Override
    public void initData() {
        super.initData();


    }
    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
