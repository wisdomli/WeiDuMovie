package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.CinemaInfoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/5
 */
public class InFoAdapter extends RecyclerView.Adapter<InFoAdapter.InFoViewHolder>{
    private Context context;
    private List<CinemaInfoBean.ResultBean> list;

    public InFoAdapter(Context context, List<CinemaInfoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InFoAdapter.InFoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.info_cinema_adapter, viewGroup, false);
        InFoViewHolder inFoViewHolder = new InFoViewHolder(inflate);
        return inFoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InFoAdapter.InFoViewHolder inFoViewHolder, int i) {
        inFoViewHolder.Cinema_img.setImageURI(list.get(i).getLogo());
        inFoViewHolder.Cinema_title.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class InFoViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView Cinema_img;
        TextView Cinema_title;
        public InFoViewHolder(@NonNull View itemView) {
            super(itemView);
            Cinema_img = itemView.findViewById(R.id.Cinema_img);
            Cinema_title = itemView.findViewById(R.id.Cinema_title);
        }
    }
}
