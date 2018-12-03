package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.QueryFollowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/3
 */
public class QueryCinemaAdapter extends RecyclerView.Adapter<QueryCinemaAdapter.QueryViewHolder>{
    private Context context;
    private List<QueryFollowBean.ResultBean> list;

    public QueryCinemaAdapter(Context context, List<QueryFollowBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    public void addPageData(List<QueryFollowBean.ResultBean> list){
        if (list!=null){
            list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public QueryCinemaAdapter.QueryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.follow_cinema, viewGroup, false);
        QueryViewHolder queryViewHolder = new QueryViewHolder(inflate);
        return queryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QueryCinemaAdapter.QueryViewHolder queryViewHolder, int i) {
        queryViewHolder.Cinema_title.setText(list.get(i).getName());
        queryViewHolder.Cinema_img.setImageURI(list.get(i).getLogo());
        queryViewHolder.Cinema_position.setText(list.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class QueryViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView Cinema_img;
        TextView Cinema_title;
        TextView Cinema_content;
        TextView Cinema_position;
        public QueryViewHolder(@NonNull View itemView) {
            super(itemView);
            Cinema_img = itemView.findViewById(R.id.Cinema_img);
            Cinema_title = itemView.findViewById(R.id.Cinema_title);
            Cinema_content = itemView.findViewById(R.id.Cinema_content);
            Cinema_position = itemView.findViewById(R.id.Cinema_content);
        }
    }
}
