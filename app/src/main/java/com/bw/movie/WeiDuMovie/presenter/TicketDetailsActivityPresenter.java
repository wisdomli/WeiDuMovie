package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MovieTicketActivity;
import com.bw.movie.WeiDuMovie.activity.TicketDetailsActivity;
import com.bw.movie.WeiDuMovie.adapter.CinemaListAdapter;
import com.bw.movie.WeiDuMovie.adapter.RecommendCinemaAdapter;
import com.bw.movie.WeiDuMovie.bean.CinemaBean;
import com.bw.movie.WeiDuMovie.bean.CinemaListBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/12/5
 **/
public class TicketDetailsActivityPresenter extends AppDelegate implements View.OnClickListener {

    private TextView film_title;
    private CinemaListAdapter cinemaListAdapter;
    private String name, img, duration, director, type, local;

    @Override
    public int getLayoutId() {
        return R.layout.ticketlist;
    }

    @Override
    public void initData() {
        super.initData();

        Intent intent = ((TicketDetailsActivity) context).getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        name = intent.getStringExtra("name");
        film_title = (TextView) get(R.id.film_title);
        film_title.setText(name);
        img = intent.getStringExtra("img");
        duration = intent.getStringExtra("duration");
        director = intent.getStringExtra("director");
        type = intent.getStringExtra("type");
        local = intent.getStringExtra("local");
        // 接口回调

        Map<String, String> map = new HashMap<>();
        map.put("movieId", movieId + "");
        getString(0, HttpUrl.CinemasListUrl, map);

        RecyclerView cinema_RecyclerView = get(R.id.cinema_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        cinema_RecyclerView.setLayoutManager(linearLayoutManager);
        cinemaListAdapter = new CinemaListAdapter(context);
        cinema_RecyclerView.setAdapter(cinemaListAdapter);
        setOnClikLisener(this, R.id.btn_back);


    }


    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Log.i("1111", data);
        Gson gson = new Gson();
        CinemaListBean cinemaBean = gson.fromJson(data, CinemaListBean.class);
        List<CinemaListBean.ResultBean> nearbyCinemaList = cinemaBean.getResult();
        cinemaListAdapter.setList(nearbyCinemaList);

        cinemaListAdapter.rsout(new CinemaListAdapter.setCinema() {
            @Override
            public void setcinemaList(int i) {
                Intent intent = new Intent(context, MovieTicketActivity.class);
                intent.putExtra("Cinema_position", nearbyCinemaList.get(i).getAddress());
                intent.putExtra("Cinema_title", nearbyCinemaList.get(i).getName());
                intent.putExtra("film_name", name);
                intent.putExtra("film_img", img);
                intent.putExtra("film_duration", duration);
                context.startActivity(intent);
            }
        });
    }


    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                ((TicketDetailsActivity) context).finish();
                break;
        }
    }


}
