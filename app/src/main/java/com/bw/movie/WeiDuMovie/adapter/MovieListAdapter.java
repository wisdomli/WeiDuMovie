package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.MovieListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <p>
 * 2018/11/29
 **/
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyHolder>{
    private List<MovieListBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public MovieListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.movielist_itrm,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyHolder myHolder, int i) {
        Glide.with(context).load(list.get(i).getImageUrl()).into(myHolder.movie_img);
        myHolder.movie_title.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MovieListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView movie_img;
        TextView movie_title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            movie_img = itemView.findViewById(R.id.movie_img);
            movie_title = itemView.findViewById(R.id.movie_title);
        }
    }
}
