package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.InFoActivity;
import com.bw.movie.weidumovie.adapter.CinemaAdapter;
import com.bw.movie.weidumovie.adapter.CommonAdapter;
import com.bw.movie.weidumovie.adapter.ScheduleAdapter;
import com.bw.movie.weidumovie.bean.ByCinemaIdBean;
import com.bw.movie.weidumovie.bean.CinemaInfoBean;
import com.bw.movie.weidumovie.bean.CommentBean;
import com.bw.movie.weidumovie.bean.MovieScheduleBean;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 作者：温浩
 * 时间：2018/12/5
 */
public class InFoActivityPresenter extends AppDelegate implements View.OnClickListener {

    private RecyclerCoverFlow home_viewpager;
    private int id;
    private CinemaAdapter byCinemaAdapter;
    private RecyclerView recy_view_schedule;
    private ScheduleAdapter scheduleAdapter;
    private View Commentdetails;
    private View btn_hide;
    private SimpleDraweeView Cinema_img;
    private TextView Cinema_title;
    private TextView Cinema_content;
    private LinearLayout CommentDetailsDialog;
    private FrameLayout frame_one_layout;
    private TextView notice_comment;
    private TextView notice_details;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ImageView image_back;
    private View details;
    private View common;
    private TextView location_text;
    private TextView phone_text;
    private TextView route_text;
    private List<ByCinemaIdBean.ResultBean> result1;
    private int id1;
    private String sessionId;
    private int userId;
    private View notice_view;
    private View noticeTwo_view;
    private RecyclerView common_recy_view;
    private CommonAdapter commonAdapter;
    private String cinemaId;


    @Override
    public int getLayoutId() {
        return R.layout.activity_info;
    }

    @Override
    public void initData() {
        super.initData();
        Commentdetails = get(R.id.Commentdetails);
        image_back = get(R.id.image_back);
        image_back.setOnClickListener(this);
        CommentDetailsDialog = get(R.id.CommentDetailsDialog);
        Cinema_content = get(R.id.Cinema_content);
        Cinema_title = get(R.id.Cinema_title);
        Cinema_img = get(R.id.Cinema_img);

        //详情
        notice_details = get(R.id.notice_details);
        notice_details.setOnClickListener(this);
        //评论
        notice_comment = get(R.id.notice_comment);
        notice_comment.setOnClickListener(this);

        notice_view = Commentdetails.findViewById(R.id.notice_view);
        noticeTwo_view = Commentdetails.findViewById(R.id.noticeTwo_view);
        //详情内容
        details = Commentdetails.findViewById(R.id.details);
        location_text = details.findViewById(R.id.location_text);//地址
        phone_text = details.findViewById(R.id.phone_text);//电话
        route_text = details.findViewById(R.id.route_text);//路线
        //评论内容
        common = Commentdetails.findViewById(R.id.common);
        //设置评论的布局
        common_recy_view = common.findViewById(R.id.common_recy_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        common_recy_view.setLayoutManager(linearLayoutManager);
         commonAdapter = new CommonAdapter(context);
        common_recy_view.setAdapter(commonAdapter);


        btn_hide = Commentdetails.findViewById(R.id.btn_hide);
        btn_hide.setOnClickListener(this);
        setOnClikLisener(this,R.id.CommentDetailsDialog,R.id.image_back);
        home_viewpager =get(R.id.home_viewpager);
        recy_view_schedule = get(R.id.recy_view_schedule);
        recy_view_schedule.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        scheduleAdapter = new ScheduleAdapter(context);
        recy_view_schedule.setAdapter(scheduleAdapter);

        sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        Intent intent = ((InFoActivity) context).getIntent();
        cinemaId = intent.getStringExtra("cinemaId");
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMapHead = new HashMap<>();
        hashMap.put("cinemaId", cinemaId);
        hashMapHead.put("sessionId", sessionId);
        hashMapHead.put("userId", userId +"");
        getString1(0, HttpUrl.CinemaInfoUrl,hashMap,hashMapHead);
        byCinemaAdapter = new CinemaAdapter(context);

        home_viewpager.setAdapter(byCinemaAdapter);
        home_viewpager.scrollToPosition(3);
        home_viewpager.smoothScrollToPosition(3);
        //传id
        byCinemaAdapter.RequestListener(new CinemaAdapter.ShowListener() {
            @Override
            public void showId(int i) {
                id1 = result1.get(i).getId();
                HashMap<String, String> map1 = new HashMap<>();
                map1.put("cinemasId", InFoActivityPresenter.this.id +"");
                map1.put("movieId", id1 +"");
                getString(2,HttpUrl.MovieScheduleUrl,map1);
            }
        });
        home_viewpager.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                int itemCount = home_viewpager.getLayoutManager().getItemCount();
            }
        });
        //详情
        HashMap<String, String> hashMap1 = new HashMap<>();
        HashMap<String, String> hashMapHead1 = new HashMap<>();
        hashMap1.put("cinemaId",id1+"");
        hashMapHead1.put("sessionId", sessionId);
        hashMapHead1.put("userId", userId + "");
        getString1(3,HttpUrl.CinemaInfoUrl,hashMap,hashMapHead);
        //评论
        HashMap<String, String> hashMap2 = new HashMap<>();
        HashMap<String, String> hashMapHead2 = new HashMap<>();
        hashMap2.put("cinemaId",cinemaId);
        hashMap2.put("page","1");
        hashMap2.put("count","5");
        hashMapHead2.put("sessionId", sessionId);
        hashMapHead2.put("userId", userId + "");
        getString1(4,HttpUrl.CommentUrl,hashMap2,hashMapHead2);
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
                String logo = result.getLogo();
                String address = result.getAddress();
                String name = result.getName();
                Cinema_content.setText(address);
                Cinema_title.setText(name);
                Cinema_img.setImageURI(logo);
                Map<String,String> map = new HashMap<>();
                map.put("cinemaId",id+"");
                getString(1,HttpUrl.ByCinemaIdUrl,map);
                break;
            case 1://电影3d轮播图
                Gson gson1 = new Gson();
                ByCinemaIdBean idBean = gson1.fromJson(data, ByCinemaIdBean.class);
                result1 = idBean.getResult();
                byCinemaAdapter.setList(result1);
                break;
            case 2://电影开始到结束时间 价格等
                Gson gson2 = new Gson();
                MovieScheduleBean movieScheduleBean = gson2.fromJson(data, MovieScheduleBean.class);
                List<MovieScheduleBean.ResultBean> beanResult = movieScheduleBean.getResult();
                scheduleAdapter.setList(beanResult);
                break;
            case 3://详情
                Gson gson3 = new Gson();
                CinemaInfoBean cinemaInfoBean = gson3.fromJson(data, CinemaInfoBean.class);
                CinemaInfoBean.ResultBean result2 = cinemaInfoBean.getResult();
                String address1 = result2.getAddress();
                String phone = result2.getPhone();
                String vehicleRoute = result2.getVehicleRoute();
                location_text.setText(address1);
                phone_text.setText(phone);
                route_text.setText(vehicleRoute);
                break;
            case 4:
                Gson gson4 = new Gson();
                CommentBean commentBean = gson4.fromJson(data, CommentBean.class);
                List<CommentBean.ResultBean> result3 = commentBean.getResult();
                commonAdapter.setList(result3);
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
        switch (view.getId()){
            //销毁当前页面
            case R.id.btn_hide:
                Commentdetails.setVisibility(View.GONE);
                break;
            case R.id.CommentDetailsDialog:
                Commentdetails.setVisibility(View.VISIBLE);
                break;
            case R.id.notice_details://详情切换
                notice_view.setVisibility(View.VISIBLE);
                noticeTwo_view.setVisibility(View.GONE);
                details.setVisibility(View.VISIBLE);
                common.setVisibility(View.GONE);
                break;
            case R.id.notice_comment://评论切换
                noticeTwo_view.setVisibility(View.VISIBLE);
                notice_view.setVisibility(View.GONE);
                common.setVisibility(View.VISIBLE);
                details.setVisibility(View.GONE);
                break;
            case R.id.image_back://销毁页面
                ((InFoActivity)context).finish();
                break;
        }
    }
}
