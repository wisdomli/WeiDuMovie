package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.adapter.IsshowingUpMovieListAdapter;
import com.bw.movie.weidumovie.adapter.HotMovieListAdapter;
import com.bw.movie.weidumovie.adapter.ShowSoonMovieListAdapter;
import com.bw.movie.weidumovie.bean.MovieListBean;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.bw.movie.weidumovie.net.NetWork;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class FilmFragmentPresenter extends AppDelegate {
    private HotMovieListAdapter movieListAdapter;
    private ShowSoonMovieListAdapter showSoonMovieListAdapter;
    private IsshowingUpMovieListAdapter isshowingUpMovieListAdapter;
    private RecyclerCoverFlow home_viewpager;
    private TabLayout home_TabLayout_view;
    private View networkView;


    @Override
    public int getLayoutId() {
        return R.layout.film_fragment;
    }

    @Override
    public void initData() {
        super.initData();


        //获取控件
        // 热门电影RecyclerView
        RecyclerView Hotmovies_RecyclerView = get(R.id.Hotmovies_RecyclerView);
        // 即将上映RecyclerView
        RecyclerView shownsoon_RecyclerView = get(R.id.shownsoon_RecyclerView);
        // 正在热映RecyclerView
        RecyclerView Isshowingup_RecyclerView = get(R.id.Isshowingup_RecyclerView);
        // 获取布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(context);
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 适配器
        movieListAdapter = new HotMovieListAdapter(context);
        showSoonMovieListAdapter = new ShowSoonMovieListAdapter(context);
        isshowingUpMovieListAdapter = new IsshowingUpMovieListAdapter(context);
        // 设置布局管理器
        Hotmovies_RecyclerView.setLayoutManager(linearLayoutManager);
        shownsoon_RecyclerView.setLayoutManager(linearLayoutManager2);
        Isshowingup_RecyclerView.setLayoutManager(linearLayoutManager3);
        // 设置适配器
        Hotmovies_RecyclerView.setAdapter(movieListAdapter);
        shownsoon_RecyclerView.setAdapter(showSoonMovieListAdapter);
        Isshowingup_RecyclerView.setAdapter(isshowingUpMovieListAdapter);

        //使用RecyclerView，自定义LayoutManager实现旋转木马相册效果
        home_viewpager = (RecyclerCoverFlow) get(R.id.home_viewpager);
        // home_viewpager.setFlatFlow(true); //平面滚动
        home_TabLayout_view = (TabLayout) get(R.id.home_TabLayout_view);
        home_viewpager.setAdapter(movieListAdapter);
        home_viewpager.scrollToPosition(3);
        home_viewpager.smoothScrollToPosition(3);
        home_viewpager.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                int itemCount = home_viewpager.getLayoutManager().getItemCount();

            }
        });


    }

    // 请求数据
    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);

        switch (type) {
            case 0:
                Gson gson = new Gson();
                MovieListBean movieListBean = gson.fromJson(data, MovieListBean.class);
                List<MovieListBean.ResultBean> result = movieListBean.getResult();
                movieListAdapter.setList(result);
                break;
            case 1:
                Gson gson1 = new Gson();
                MovieListBean movieListBean1 = gson1.fromJson(data, MovieListBean.class);
                List<MovieListBean.ResultBean> result1 = movieListBean1.getResult();
                isshowingUpMovieListAdapter.setList(result1);
                break;
            case 2:
                Gson gson2 = new Gson();
                MovieListBean movieListBean2 = gson2.fromJson(data, MovieListBean.class);
                List<MovieListBean.ResultBean> result2 = movieListBean2.getResult();
                showSoonMovieListAdapter.setList(result2);
                break;
        }

    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    public void onResume() {
        // 判断有网无网
        networkView = get(R.id.networkView);
        Map<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("count", "20");
        if (NetWork.isConnected(context)) {
            // 热门电影请求
            getString(0, HttpUrl.HotmoviesUrl + "?", map);
            // 正在热映请求
            getString(1, HttpUrl.ShowingUpUrl + "?", map);
            // 即将上映请求
            getString(2, HttpUrl.ShowSoonUrl, map);
            movieListAdapter.notifyDataSetChanged();
            showSoonMovieListAdapter.notifyDataSetChanged();
            isshowingUpMovieListAdapter.notifyDataSetChanged();
            networkView.setVisibility(View.GONE);
        } else {
            networkView.setVisibility(View.VISIBLE);
        }


    }
}
