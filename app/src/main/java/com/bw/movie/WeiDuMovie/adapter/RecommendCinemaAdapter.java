package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.InFoActivity;
import com.bw.movie.WeiDuMovie.bean.CinemaBean;
import com.bw.movie.WeiDuMovie.bean.SuccessCinemaFollow;
import com.bw.movie.WeiDuMovie.net.HttpHelper;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class RecommendCinemaAdapter extends RecyclerCoverFlow.Adapter<RecommendCinemaAdapter.MyHolder>{
    private List<CinemaBean.ResultBean.NearbyCinemaListBean> list = new ArrayList<>();
    private Context context;
    private int id;

    public RecommendCinemaAdapter(Context context) {
        this.context = context;
    }

    public void addPageData(List<CinemaBean.ResultBean.NearbyCinemaListBean> list){
        if (list!=null){
            list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecommendCinemaAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = View.inflate(context, R.layout.cinema_itrm,null);
       MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendCinemaAdapter.MyHolder myHolder, int i) {
        myHolder.Cinema_img.setImageURI(list.get(i).getLogo());
        myHolder.Cinema_title.setText(list.get(i).getName());
        myHolder.Cinema_position.setText(list.get(i).getAddress());
        id = list.get(i).getId();
        //点击进入详情
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InFoActivity.class);
                intent.putExtra("cinemaId",list.get(i).getId()+"");
                context.startActivity(intent);
            }
        });
        myHolder.Cinema_follow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initDate();
                notifyDataSetChanged();
            }
        });

    }

    private void initDate() {
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashMapHead = new HashMap<>();
        hashMap.put("cinemaId",id+"");
        hashMapHead.put("sessionId",sessionId);
        hashMapHead.put("userId",userId+"");
        hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
        new HttpHelper().get1(HttpUrl.SuccessCinemaFollow,hashMap,hashMapHead).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                Gson gson = new Gson();
                SuccessCinemaFollow successBean = gson.fromJson(data, SuccessCinemaFollow.class);
                String status = successBean.getStatus();
                String message = successBean.getMessage();
                if (status.equals("0000")){
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void erorr(String erorr) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CinemaBean.ResultBean.NearbyCinemaListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView Cinema_follow_img;
        SimpleDraweeView Cinema_img;
        TextView Cinema_title;
        TextView Cinema_content;
        TextView Cinema_position;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            Cinema_img = itemView.findViewById(R.id.Cinema_img);
            Cinema_title = itemView.findViewById(R.id.Cinema_title);
            Cinema_content = itemView.findViewById(R.id.Cinema_content);
            Cinema_position = itemView.findViewById(R.id.Cinema_content);
            Cinema_follow_img = itemView.findViewById(R.id.Cinema_follow_img);
        }
    }
}
