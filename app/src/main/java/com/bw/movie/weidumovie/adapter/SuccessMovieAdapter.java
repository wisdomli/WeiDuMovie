package com.bw.movie.weidumovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.bean.MovieQueryFollowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/4
 */
public class SuccessMovieAdapter extends RecyclerView.Adapter<SuccessMovieAdapter.MovieViewHolder>{
    private Context context;
    private List<MovieQueryFollowBean.ResultBean> list;

    public SuccessMovieAdapter(Context context, List<MovieQueryFollowBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    public void addPageData(List<MovieQueryFollowBean.ResultBean> list){
        if (list!=null){
            list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public SuccessMovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.follow_cinema, viewGroup, false);
        MovieViewHolder queryViewHolder = new MovieViewHolder(inflate);
        return queryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuccessMovieAdapter.MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.Cinema_title.setText(list.get(i).getName());
        movieViewHolder.Cinema_img.setImageURI(list.get(i).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView Cinema_img;
        TextView Cinema_title;
        TextView Cinema_content;
        TextView Cinema_position;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            Cinema_img = itemView.findViewById(R.id.Cinema_img);
            Cinema_title = itemView.findViewById(R.id.Cinema_title);
            Cinema_content = itemView.findViewById(R.id.Cinema_content);
            Cinema_position = itemView.findViewById(R.id.Cinema_content);
        }
    }
}
