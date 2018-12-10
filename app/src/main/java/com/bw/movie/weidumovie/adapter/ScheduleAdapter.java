package com.bw.movie.weidumovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.bean.MovieScheduleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/6
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>{
    private Context context;
    private List<MovieScheduleBean.ResultBean> list = new ArrayList<>();

    public ScheduleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.schedule_adapter_layout, viewGroup, false);
        ScheduleViewHolder scheduleViewHolder = new ScheduleViewHolder(inflate);
        return scheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ScheduleViewHolder scheduleViewHolder, int i) {
        scheduleViewHolder.hall_text.setText(list.get(i).getScreeningHall());
        scheduleViewHolder.price_text.setText(""+list.get(i).getSeatsTotal());
        scheduleViewHolder.time_text.setText(""+list.get(i).getBeginTime());
        scheduleViewHolder.time_stop.setText(""+list.get(i).getEndTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MovieScheduleBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        private TextView price_text;
        private TextView hall_text;
        private TextView time_text,time_stop;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            price_text = itemView.findViewById(R.id.price_text);
            hall_text = itemView.findViewById(R.id.hall_text);
            time_text = itemView.findViewById(R.id.time_text);
            time_stop = itemView.findViewById(R.id.time_stop);
        }
    }
}
