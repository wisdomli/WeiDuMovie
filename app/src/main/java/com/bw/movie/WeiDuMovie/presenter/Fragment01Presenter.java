package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class Fragment01Presenter extends AppDelegate{

    private RecyclerView recyview_fime;

    @Override
    public int getLayoutId() {
        return R.layout.fragment01;
    }

    @Override
    public void initData() {
        super.initData();
        recyview_fime = get(R.id.recyview_fime);
    }

    @Override
    public void getContext(Context context) {
        super.getContext(context);
    }

}
