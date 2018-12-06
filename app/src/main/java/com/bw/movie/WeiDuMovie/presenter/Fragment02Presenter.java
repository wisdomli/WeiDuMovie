package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.adapter.QueryCinemaAdapter;
import com.bw.movie.WeiDuMovie.bean.QueryFollowBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class Fragment02Presenter extends AppDelegate {
    private int pagee = 1;
    private XRecyclerView xrecyview_cinema;
    private QueryCinemaAdapter cinemaAdapter;
    private QueryFollowBean queryFollowBean;
    private Map<String, String> hashMap;

    @Override
    public int getLayoutId() {
        return R.layout.fragment02;
    }

    @Override
    public void initData() {
        super.initData();
        doDate(pagee);
        xrecyview_cinema = get(R.id.xrecyview_cinema);
        xrecyview_cinema.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        xrecyview_cinema.setLoadingMoreEnabled(true);
        xrecyview_cinema.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pagee = 1;
                doDate(pagee);
            }

            @Override
            public void onLoadMore() {
                pagee++;
                doDate(pagee);
            }
        });
    }

    private void doDate(int pagee) {
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        hashMap = new HashMap<>();
        Map<String, String> hashMapHead = new HashMap<>();
        hashMap.put("page", "1");
        hashMap.put("count", "10");
        hashMap.put("pagee", pagee + "");
        hashMapHead.put("sessionId", sessionId);
        hashMapHead.put("userId", userId + "");
        hashMapHead.put("Content-Type", "application/x-www-form-urlencoded");
        getString1(0, HttpUrl.QueryCinemaUrl, hashMap, hashMapHead);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        queryFollowBean = gson.fromJson(data, QueryFollowBean.class);
        if (queryFollowBean != null && queryFollowBean.getResult() != null) {
            if (pagee == 1) {
                List<QueryFollowBean.ResultBean> list = queryFollowBean.getResult();
                cinemaAdapter = new QueryCinemaAdapter(context, list);
                xrecyview_cinema.setAdapter(cinemaAdapter);
                xrecyview_cinema.refreshComplete();
            } else {
                if (cinemaAdapter != null) {
                    cinemaAdapter.addPageData(queryFollowBean.getResult());
                }
                xrecyview_cinema.loadMoreComplete();
            }
        }

    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
