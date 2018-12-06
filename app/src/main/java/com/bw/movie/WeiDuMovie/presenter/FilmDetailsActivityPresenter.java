package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.FilmDetailsActivity;
import com.bw.movie.WeiDuMovie.adapter.NoticevideoAdapter;
import com.bw.movie.WeiDuMovie.adapter.StillsAdapter;
import com.bw.movie.WeiDuMovie.bean.FilmDetailsBean;
import com.bw.movie.WeiDuMovie.bean.FilmReviewBean;
import com.bw.movie.WeiDuMovie.bean.SuccessCinemaFollow;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/12/2
 **/
public class FilmDetailsActivityPresenter extends AppDelegate implements View.OnClickListener {
    private SimpleDraweeView FilmDetails_img;
    private TextView filmDetails_title;
    private SimpleDraweeView filmDetails_img_Gaussfuzzy;
    private Button btn;
    private View DetailsView;
    private SimpleDraweeView filmDetails_img;
    private TextView details_name;
    private FilmDetailsBean.ResultBean result = new FilmDetailsBean.ResultBean();
    private TextView type_name;
    private TextView director_name;
    private TextView duration_name;
    private TextView local_name;
    private TextView plot_content;
    private TextView Details_title;
    private TextView performer;
    private View noticeview;
    private NoticevideoAdapter noticevideoAdapter;
    private View stillsview;
    private StillsAdapter stillsAdapter;
    private View filmreview;
    private ImageView image_follow_film;
    private int id;
    private boolean followMovie;

    @Override
    public int getLayoutId() {
        return R.layout.filmdetails;
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = ((FilmDetailsActivity) context).getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Map<String, String> map = new HashMap<>();
        map.put("movieId", movieId + "");
        getString(0, HttpUrl.MoviesDetailUrl, map);// 请求接口

        FilmDetails_img = (SimpleDraweeView) get(R.id.filmDetails_img);
        filmDetails_img_Gaussfuzzy = (SimpleDraweeView) get(R.id.filmDetails_img_Gaussfuzzy);
        filmDetails_title = (TextView) get(R.id.filmDetails_title);// 电影详情
        details_name = (TextView) get(R.id.details_name);// 电影详情
        image_follow_film = get(R.id.image_follow_film);//关注
        setOnClikLisener(this,
                R.id.filmDetails_btn_back, // 返回销毁当前页面
                R.id.filmDetails_btn_Tickebuy,// 购票
                R.id.filmDetails_btn_Details,// 详情
                R.id.filmDetails_btn_Notice,// 预告
                R.id.filmDetails_btn_Stills,// 剧照
                R.id.image_follow_film,//关注
                R.id.filmDetails_btn_Filmreview);// 影评
        /**
         * 详情
         */
        DetailsView = get(R.id.DetailsView);// 详情View
        filmDetails_img = (SimpleDraweeView) DetailsView.findViewById(R.id.filmDetails_img);
        DetailsView.findViewById(R.id.btn_hide).setOnClickListener(this);
        type_name = DetailsView.findViewById(R.id.type_name);
        director_name = (TextView) DetailsView.findViewById(R.id.director_name);
        duration_name = (TextView) DetailsView.findViewById(R.id.duration_name);
        local_name = (TextView) DetailsView.findViewById(R.id.local_name);
        plot_content = (TextView) DetailsView.findViewById(R.id.plot_content);
        Details_title = (TextView) DetailsView.findViewById(R.id.Details_title);
        performer = (TextView) DetailsView.findViewById(R.id.performer);
        /**
         * 预告
         */
        noticeview = get(R.id.noticeview);
        noticeview.findViewById(R.id.btn_hide).setOnClickListener(this);
        RecyclerView noticeRecyclerView = noticeview.findViewById(R.id.noticeRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        noticeRecyclerView.setLayoutManager(linearLayoutManager);
        noticevideoAdapter = new NoticevideoAdapter(context);
        noticeRecyclerView.setAdapter(noticevideoAdapter);
        /**
         * 剧照
         */
        stillsview = get(R.id.stillsview);
        stillsview.findViewById(R.id.btn_hide).setOnClickListener(this);
        RecyclerView stillsRecyclerView = stillsview.findViewById(R.id.stillsRecyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        stillsRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        stillsAdapter = new StillsAdapter(context);
        stillsRecyclerView.setAdapter(stillsAdapter);
        /**
         *影评
         */
        filmreview = get(R.id.filmreview);
        filmreview.findViewById(R.id.btn_hide).setOnClickListener(this);


        if (followMovie){
            image_follow_film.setImageResource(R.drawable.com_icon_collection_selected);
        }else {
            image_follow_film.setImageResource(R.drawable.com_icon_collection_default);

        }

    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        switch (type) {
            case 0:
                Gson gson = new Gson();
                FilmDetailsBean filmDetailsBean = gson.fromJson(data, FilmDetailsBean.class);
                result = filmDetailsBean.getResult();
                result.setFollowMovie(false);
                followMovie = result.isFollowMovie();

                id = result.getId();
                String imageUrl = result.getImageUrl();
                filmDetails_img.setImageURI(imageUrl);
                filmDetails_img_Gaussfuzzy.setImageURI(imageUrl);
                FilmDetails_img.setImageURI(imageUrl);
                filmDetails_title.setText(result.getName());// 电影详情
                type_name.setText(result.getMovieTypes());// 电影类型
                director_name.setText(result.getDirector());// 电影导演
                duration_name.setText(result.getDuration()); // 电影时长
                local_name.setText(result.getPlaceOrigin()); // 电影产地
                plot_content.setText(result.getSummary()); // 电影简介
                performer.setText(result.getStarring());// 演员列表
                List<FilmDetailsBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();// 预告片列表
                noticevideoAdapter.setList(shortFilmList);// 预告片
                List<String> posterList = result.getPosterList();
                stillsAdapter.setList(posterList);// 剧照
                // 请求影评接口
                Map<String,String> map = new HashMap<>();
                Map<String,String> mapHead = new HashMap<>();
                SharedPreferences config = context.getSharedPreferences("config", 0);
                String sessionId = config.getString("sessionId", "");
                int userId = config.getInt("userId", 0);
                mapHead.put("sessionId",sessionId);
                mapHead.put("userId",userId+"");
                map.put("movieId",result.getId()+"");
                map.put("page","1");
                map.put("count","5");
                getString1(1,HttpUrl.FilmreviewUrl,map,mapHead);
                break;
            case 1:
            Gson gson1 = new Gson();
                FilmReviewBean filmReviewBean = gson1.fromJson(data, FilmReviewBean.class);
                List<FilmReviewBean.ResultBean> result = filmReviewBean.getResult();

                break;
            case 2:
                Gson gson2 = new Gson();
                SuccessCinemaFollow successBean = gson2.fromJson(data, SuccessCinemaFollow.class);
                String status = successBean.getStatus();
                String message = successBean.getMessage();
                if (status.equals("0000")){

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
                break;
        }


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
            // 详情
            case R.id.filmDetails_btn_Details:
                DetailsView.setVisibility(View.VISIBLE);
                details_name.setText(result.getName());
                Details_title.setText(result.getName());
                filmDetails_title.setText("");
                break;
            case R.id.filmDetails_btn_back:
                ((FilmDetailsActivity) context).finish();
                break;
            case R.id.filmDetails_btn_Tickebuy:
                Toast.makeText(context, "支付功能暂未实现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_hide:
                DetailsView.setVisibility(View.GONE);
                noticeview.setVisibility(View.GONE);
                stillsview.setVisibility(View.GONE);
                filmreview.setVisibility(View.GONE);
                details_name.setText("电影详情");
                filmDetails_title.setText(result.getName());
                break;
            case R.id.filmDetails_btn_Notice:
                noticeview.setVisibility(View.VISIBLE);
                details_name.setText(result.getName());
                filmDetails_title.setText("");
                break;
            case R.id.filmDetails_btn_Stills:
                stillsview.setVisibility(View.VISIBLE);
                details_name.setText(result.getName());
                filmDetails_title.setText("");
                break;
            case R.id.filmDetails_btn_Filmreview:
                filmDetails_title.setText("");
                filmreview.setVisibility(View.VISIBLE);
                break;

            case R.id.image_follow_film:
                    result.setFollowMovie(true);

                String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
                int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
                Map<String, String> hashMap = new HashMap<>();
                Map<String, String> hashMapHead = new HashMap<>();
                hashMap.put("movieId",id+"");
                hashMapHead.put("sessionId",sessionId);
                hashMapHead.put("userId",userId+"");
                hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
                getString1(2,HttpUrl.MovieSuccessFollow,hashMap,hashMapHead);
                break;
        }
    }
}
