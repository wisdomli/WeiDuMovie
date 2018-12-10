package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;


import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.adapter.SuccessMovieAdapter;
import com.bw.movie.weidumovie.bean.MovieQueryFollowBean;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class Fragment01Presenter extends AppDelegate {

    private int pagee = 1;
    private XRecyclerView xrecyview_fime;
    private SuccessMovieAdapter successMovieAdapter;
    private MovieQueryFollowBean queryFollowBean;

    @Override
    public int getLayoutId() {
        return R.layout.fragment01;
    }

    @Override
    public void initData() {
        super.initData();
        doHttp(pagee);
        xrecyview_fime = get(R.id.xrecyview_fime);
        xrecyview_fime.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        xrecyview_fime.setLoadingMoreEnabled(true);
        xrecyview_fime.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pagee = 1;
                doHttp(pagee);
            }

            @Override
            public void onLoadMore() {
                pagee++;
                doHttp(pagee);
            }
        });
    }

    private void doHttp(int pagee) {
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashMapHead = new HashMap<>();
        hashMap.put("count", "10");
        hashMap.put("page", "1");
        hashMap.put("pagee", pagee + "");
        hashMapHead.put("sessionId", sessionId);
        hashMapHead.put("userId", userId + "");
        hashMapHead.put("Content-Type", "application/x-www-form-urlencoded");
        getString1(0, HttpUrl.MovieQueryUrl, hashMap, hashMapHead);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        queryFollowBean = gson.fromJson(data, MovieQueryFollowBean.class);
        if (queryFollowBean != null && queryFollowBean.getResult() != null) {
            if (pagee == 1) {
                List<MovieQueryFollowBean.ResultBean> list = queryFollowBean.getResult();
                successMovieAdapter = new SuccessMovieAdapter(context, list);
                xrecyview_fime.setAdapter(successMovieAdapter);
                xrecyview_fime.refreshComplete();
            } else {
                if (successMovieAdapter != null) {
                    successMovieAdapter.addPageData(queryFollowBean.getResult());
                }
                xrecyview_fime.loadMoreComplete();
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
