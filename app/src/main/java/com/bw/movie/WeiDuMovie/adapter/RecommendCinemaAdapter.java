package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.CinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class RecommendCinemaAdapter extends RecyclerCoverFlow.Adapter<RecommendCinemaAdapter.MyHolder>{
    private List<CinemaBean.ResultBean.NearbyCinemaListBean> list = new ArrayList<>();
    private Context context;

    public RecommendCinemaAdapter(Context context) {
        this.context = context;
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
        }
    }
}
