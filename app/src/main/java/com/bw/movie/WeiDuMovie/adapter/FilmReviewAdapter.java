package com.bw.movie.WeiDuMovie.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.FilmReviewBean;
import com.bw.movie.WeiDuMovie.bean.FollowSuccessBean;
import com.bw.movie.WeiDuMovie.net.HttpHelper;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/12/4
 **/
public class FilmReviewAdapter extends RecyclerView.Adapter<FilmReviewAdapter.MyHolder>{
    private List<FilmReviewBean.ResultBean> list = new ArrayList<>();
    private Context context;
    private int commentId;
    private MyHolder myHolder;

    public FilmReviewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FilmReviewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.filmreviewitrm,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmReviewAdapter.MyHolder myHolder, int i) {
        myHolder.user_img.setImageURI(list.get(i).getCommentHeadPic());
        myHolder.user_name.setText(list.get(i).getCommentUserName());
        myHolder.user_content.setText(list.get(i).getCommentContent());
        myHolder.praise_img.setImageResource(R.drawable.com_icon_praise_selected);

        long commentTime = list.get(i).getCommentTime();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd   HH:mm");
        String format = format2.format(new Date(commentTime));
        myHolder.user_time.setText(format);
        commentId = list.get(i).getCommentId();
        myHolder.praise_number.setText(list.get(i).getGreatNum()+"");
        myHolder.message_number.setText(list.get(i).getReplyNum()+"");
       myHolder.praise_img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

//             setPraise.setpraise();
               list.get(i).setGreatNum(list.get(i).getReplyNum()+1);
               Map<String,String> map = new HashMap<>();
               Map<String,String> handMap = new HashMap<>();
               map.put("commentId",commentId+"");
               SharedPreferences config = context.getSharedPreferences("config", 0);
               String sessionId = config.getString("sessionId", "");
               int userId = config.getInt("userId", 0);
               handMap.put("sessionId",sessionId);
               handMap.put("userId",userId+"");
               new HttpHelper().post1(HttpUrl.PraiseUrl,map,handMap).rosout(new HttpHelper.HttpLsener() {
                   @Override
                   public void suecss(String data) {
                       Gson gson = new Gson();
                       FollowSuccessBean followSuccessBean = gson.fromJson(data, FollowSuccessBean.class);
                       if (followSuccessBean.getStatus()=="0000"){
                        list.get(i).setGreatNum(list.get(i).getGreatNum()+1);

                           Toast.makeText(context, followSuccessBean.getMessage(),Toast.LENGTH_SHORT).show();

                       }else {
                           Toast.makeText(context, followSuccessBean.getMessage(),Toast.LENGTH_SHORT).show();
                       }

                   }

                   @Override
                   public void erorr(String erorr) {

                   }
               });

               notifyItemChanged(i);
           }
       });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<FilmReviewBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView user_img;
        TextView user_name;
        TextView user_content;
        TextView user_time;
        TextView praise_number;
        TextView message_number;
        ImageView praise_img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.user_img);
            user_name = itemView.findViewById(R.id.user_name);
            user_content = itemView.findViewById(R.id.user_content);
            user_time = itemView.findViewById(R.id.user_time);
            praise_number = itemView.findViewById(R.id.praise_number);
            message_number = itemView.findViewById(R.id.message_number);
            praise_img = itemView.findViewById(R.id.praise_img);
        }
    }
    private setPraise setPraise;
    public void rsout(setPraise setPraise){
        this.setPraise = setPraise;
    }
    public interface setPraise{
        void setpraise();
    }
}
