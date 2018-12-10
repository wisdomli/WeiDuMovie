package com.bw.movie.weidumovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.bean.FilmDetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <p>
 * 2018/12/3
 **/
public class StillsAdapter extends RecyclerView.Adapter<StillsAdapter.MyHolder>{
    private List<String> list = new ArrayList<>();
    private Context context;

    public StillsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StillsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.stillsitrm,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StillsAdapter.MyHolder myHolder, int i) {

        Glide.with(context).load(list.get(i)).into(myHolder.stills_img);
//        myHolder.stills_img.setImageURI(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView stills_img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            stills_img = itemView.findViewById(R.id.stills_img);
        }
    }
}
