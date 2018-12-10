package com.bw.movie.weidumovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.FilmDetailsActivity;
import com.bw.movie.weidumovie.bean.ByCinemaIdBean;
import com.bw.movie.weidumovie.bean.CinemaInfoBean;
import com.bw.movie.weidumovie.bean.MovieListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <p>
 * 2018/11/29
 **/
public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.MyHolder>{
    private List<ByCinemaIdBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public CinemaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CinemaAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.cinematicket,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaAdapter.MyHolder myHolder, final int i) {
        myHolder.movie_img.setImageURI(list.get(i).getImageUrl());
        myHolder.movie_title.setText(list.get(i).getName());
        showListener.showId(i);
    }

    @Override
    public int getItemCount() {
            return list.size();
    }

    public void setList(List<ByCinemaIdBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView movie_img;
        TextView movie_title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            movie_img = itemView.findViewById(R.id.movie_img);
            movie_title = itemView.findViewById(R.id.movie_title);
        }
    }
    private ShowListener showListener;

    public void RequestListener(ShowListener showListener){
        this.showListener = showListener;
    }
    public interface ShowListener{
        void showId(int i);
    }
}
