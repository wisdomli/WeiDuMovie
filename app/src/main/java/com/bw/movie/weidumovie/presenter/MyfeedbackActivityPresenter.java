package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.FeedbacksuccessActivity;
import com.bw.movie.weidumovie.activity.MyfeedbackActivity;
import com.bw.movie.weidumovie.bean.FeedbackBean;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyfeedbackActivityPresenter extends AppDelegate{

    private ImageView image_back;
    private EditText edit_context;
    private RelativeLayout submission;
    private HashMap<String, String> hashMap;
    private HashMap<String, String> hashMapHead;
    private String message;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_feedback;
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        FeedbackBean feedbackBean = gson.fromJson(data, FeedbackBean.class);
        String status = feedbackBean.getStatus();
        message = feedbackBean.getMessage();
        if (status.equals("0000")){
            Toast.makeText(context, message,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, FeedbacksuccessActivity.class);
            context.startActivity(intent);
        }else {
            Toast.makeText(context, message,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void initData() {
        super.initData();
        image_back = get(R.id.image_back);
        edit_context = get(R.id.edit_context);
        submission = get(R.id.submission);
        hashMap = new HashMap<>();
        hashMapHead = new HashMap<>();
        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取保存的id以及登录凭证
                String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
                int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
                String context1 = edit_context.getText().toString().trim();
                if (context1.isEmpty()){
                    Toast.makeText(context,"请输入内容",Toast.LENGTH_SHORT).show();
                }else if (!context1.isEmpty()){
                    hashMap.put("content",context1);
                    hashMapHead.put("sessionId",sessionId);
                    hashMapHead.put("userId",userId+"");
                    hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
                    postString1(0,HttpUrl.FeedBackUrl,hashMap,hashMapHead);
                }
            }
        });
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyfeedbackActivity) context).finish();
            }
        });
    }
    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
