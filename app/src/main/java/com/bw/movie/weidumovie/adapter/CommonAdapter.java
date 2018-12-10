package com.bw.movie.weidumovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.bean.CommentBean;
import com.bw.movie.weidumovie.bean.CommentGreatBean;
import com.bw.movie.weidumovie.net.HttpHelper;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/12/8
 */
public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.CommonViewHolder>{

    private List<CommentBean.ResultBean> list = new ArrayList<>();
    private Context context;
    private int commentId;

    public CommonAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CommonAdapter.CommonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.common_adapter_layput, viewGroup, false);
        CommonViewHolder commonViewHolder = new CommonViewHolder(inflate);
        return commonViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonAdapter.CommonViewHolder commonViewHolder, int i) {
        commonViewHolder.user_img.setImageURI(list.get(i).getCommentHeadPic());
        commonViewHolder.user_name.setText(list.get(i).getCommentUserName());
        commonViewHolder.user_content.setText(list.get(i).getCommentContent());
        commentId = list.get(i).getCommentId();
        long commentTime = list.get(i).getCommentTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:dd");
        String format = simpleDateFormat.format(commentTime);
        commonViewHolder.user_time.setText(format);

        commonViewHolder.praise_number.setText(""+list.get(i).getGreatNum());
        //点赞
        commonViewHolder.praise_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doHttp();
                commonViewHolder.praise_img.setImageResource(R.drawable.com_icon_praise_selected);
            }
        });
    }

    private void doHttp() {
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        HashMap<String, String> hashMapHead = new HashMap<>();
        Map<String,String> map = new HashMap<>();
        map.put("commentId",commentId+"");
        hashMapHead.put("sessionId",sessionId);
        hashMapHead.put("userId",userId+"");
        hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
        new HttpHelper().post1(HttpUrl.CommentGreatUrl,map,hashMapHead).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                Gson gson = new Gson();

                CommentGreatBean commentGreatBean = gson.fromJson(data, CommentGreatBean.class);
                String message = commentGreatBean.getMessage();
                String status = commentGreatBean.getStatus();
                if (status.equals("0000")){

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void erorr(String erorr) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<CommentBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class CommonViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView user_img;
        TextView user_name;
        TextView user_content;
        TextView user_time;
        TextView praise_number;
        ImageView praise_img;
        public CommonViewHolder(View inflate) {
            super(inflate);
            user_img = itemView.findViewById(R.id.user_img1);
            user_name = itemView.findViewById(R.id.user_name1);
            user_content = itemView.findViewById(R.id.user_content1);
            user_time = itemView.findViewById(R.id.user_time1);
            praise_number = itemView.findViewById(R.id.praise_number1);
            praise_img = itemView.findViewById(R.id.praise_img1);
        }
    }
}
