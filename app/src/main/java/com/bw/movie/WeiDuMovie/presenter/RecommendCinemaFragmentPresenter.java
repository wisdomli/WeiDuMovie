package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.adapter.RecommendCinemaAdapter;
import com.bw.movie.WeiDuMovie.bean.CinemaBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class RecommendCinemaFragmentPresenter extends AppDelegate {
    private RecommendCinemaAdapter recommendCinemaAdapter;
    private XRecyclerView RecommendRecView;

    @Override
    public int getLayoutId() {
        return R.layout.recommendcinema;
    }


   private int page = 1;
    @Override
    public void initData() {
        super.initData();

        doHttp(page);
        RecommendRecView = (XRecyclerView) get(R.id.RecommendRecView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        RecommendRecView.setLayoutManager(linearLayoutManager);
        recommendCinemaAdapter = new RecommendCinemaAdapter(context);
        RecommendRecView.loadMoreComplete();
        RecommendRecView.setLoadingMoreEnabled(true);
        RecommendRecView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page =1;
                doHttp(page);
            }

            @Override
            public void onLoadMore() {
                page++;
              doHttp(page);

            }
        });
        recommendCinemaAdapter.notifyDataSetChanged();
        RecommendRecView.setAdapter(recommendCinemaAdapter);
    }

    private void doHttp(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("count", "20");
        getString(0, HttpUrl.CinemasUrl, map);
    }


    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        CinemaBean cinemaBean = gson.fromJson(data, CinemaBean.class);
        List<CinemaBean.ResultBean.NearbyCinemaListBean> nearbyCinemaList = cinemaBean.getResult().getNearbyCinemaList();
        recommendCinemaAdapter.setList(nearbyCinemaList);
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}