package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.FilmDetailsBean;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * 作者:李自强
 * <p>
 * 2018/12/3
 **/
public class NoticevideoAdapter extends RecyclerView.Adapter<NoticevideoAdapter.MyHolder> {
    private List<FilmDetailsBean.ResultBean.ShortFilmListBean> listBeans = new ArrayList<>();
    private Context context;

    public NoticevideoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NoticevideoAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.noticeitem, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticevideoAdapter.MyHolder myHolder, int i) {
        myHolder.videoplayer.setUp(listBeans.get(i).getVideoUrl(), "", Jzvd.SCREEN_WINDOW_NORMAL);
        Glide.with(context).load(listBeans.get(i).getImageUrl()).into(myHolder.videoplayer.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public void setList(List<FilmDetailsBean.ResultBean.ShortFilmListBean> listBeans) {
        this.listBeans = listBeans;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        JzvdStd videoplayer;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            videoplayer = itemView.findViewById(R.id.videoplayer);

        }
    }
}
