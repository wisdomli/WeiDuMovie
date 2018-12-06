package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MovieTicketActivity;
import com.bw.movie.WeiDuMovie.activity.TicketDetailsActivity;
import com.bw.movie.WeiDuMovie.bean.CinemaBean;
import com.bw.movie.WeiDuMovie.bean.CinemaListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <p>
 * 2018/12/1
 **/
public class CinemaListAdapter extends RecyclerView.Adapter<CinemaListAdapter.MyHolder> {
    private List<CinemaListBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public CinemaListAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CinemaListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.cinema_itrm, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaListAdapter.MyHolder myHolder, int i) {
        myHolder.Cinema_img.setImageURI(list.get(i).getLogo());
        myHolder.Cinema_title.setText(list.get(i).getName());
        myHolder.Cinema_position.setText(list.get(i).getAddress());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setcinema.setcinemaList(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CinemaListBean.ResultBean> list) {
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

    // 定义接口回调
    public setCinema setcinema;

    public void rsout(setCinema setcinema) {
        this.setcinema = setcinema;
    }

    public interface setCinema {
        void setcinemaList(int i);
    }
}
