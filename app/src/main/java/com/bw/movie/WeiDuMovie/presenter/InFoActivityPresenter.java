package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.InFoActivity;
import com.bw.movie.WeiDuMovie.adapter.CinemaAdapter;
import com.bw.movie.WeiDuMovie.adapter.InFoAdapter;
import com.bw.movie.WeiDuMovie.adapter.ScheduleAdapter;
import com.bw.movie.WeiDuMovie.bean.ByCinemaIdBean;
import com.bw.movie.WeiDuMovie.bean.CinemaInfoBean;
import com.bw.movie.WeiDuMovie.bean.MovieScheduleBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 作者：温浩
 * 时间：2018/12/5
 */
public class InFoActivityPresenter extends AppDelegate {

    private RecyclerView film_list_recy;
    private RecyclerCoverFlow home_viewpager;
    private int id;
    private CinemaAdapter byCinemaAdapter;
    private RecyclerView recy_view_schedule;
    private ScheduleAdapter scheduleAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_info;
    }

    @Override
    public void initData() {
        super.initData();
        film_list_recy = get(R.id.film_list_recy);
        home_viewpager =get(R.id.home_viewpager);
        recy_view_schedule = get(R.id.recy_view_schedule);
        recy_view_schedule.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
      scheduleAdapter = new ScheduleAdapter(context);
        recy_view_schedule.setAdapter(scheduleAdapter);

        film_list_recy.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        Intent intent = ((InFoActivity) context).getIntent();
        String cinemaId = intent.getStringExtra("cinemaId");
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMapHead = new HashMap<>();
        hashMap.put("cinemaId",cinemaId);
        hashMapHead.put("sessionId",sessionId);
        hashMapHead.put("userId",userId+"");
        getString1(0, HttpUrl.CinemaInfoUrl,hashMap,hashMapHead);
        byCinemaAdapter = new CinemaAdapter(context);
        home_viewpager.setAdapter(byCinemaAdapter);
        home_viewpager.scrollToPosition(3);
        home_viewpager.smoothScrollToPosition(3);
        byCinemaAdapter.RequestListener(new CinemaAdapter.ShowListener() {
            @Override
            public void showId(int id1) {
                HashMap<String, String> map1 = new HashMap<>();
                map1.put("cinemasId",id+"");
                map1.put("movieId",id1+"");
                getString(2,HttpUrl.MovieScheduleUrl,map1);
            }
        });
        home_viewpager.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                int itemCount = home_viewpager.getLayoutManager().getItemCount();
            }
        });
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        switch (type){
            case 0:
                Gson gson = new Gson();
                CinemaInfoBean cinemaInfo = gson.fromJson(data, CinemaInfoBean.class);
                CinemaInfoBean.ResultBean result = cinemaInfo.getResult();
                id = result.getId();
                Map<String,String> map = new HashMap<>();
                map.put("cinemaId",id+"");
                getString(1,HttpUrl.ByCinemaIdUrl,map);
                ArrayList<CinemaInfoBean.ResultBean> list = new ArrayList<>();
                list.add(result);
                InFoAdapter inFoAdapter = new InFoAdapter(context, list);
                film_list_recy.setAdapter(inFoAdapter);
                break;
            case 1:
                Gson gson1 = new Gson();
                ByCinemaIdBean idBean = gson1.fromJson(data, ByCinemaIdBean.class);
                List<ByCinemaIdBean.ResultBean> result1 = idBean.getResult();
                byCinemaAdapter.setList(result1);
                break;
            case 2:
                Gson gson2 = new Gson();
                MovieScheduleBean movieScheduleBean = gson2.fromJson(data, MovieScheduleBean.class);
                List<MovieScheduleBean.ResultBean> beanResult = movieScheduleBean.getResult();
                scheduleAdapter.setList(beanResult);
                break;
        }
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
