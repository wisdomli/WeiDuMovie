package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MyMessageActivity;
import com.bw.movie.WeiDuMovie.activity.MyfeedbackActivity;
import com.bw.movie.WeiDuMovie.bean.FeedbackBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

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
                String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
                int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
                String context = edit_context.getText().toString();
                hashMap.put("content",context);
                hashMapHead.put("sessionId",sessionId);
                hashMapHead.put("userId",userId+"");
                hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
                postString1(0,HttpUrl.FeedBackUrl,hashMap,hashMapHead);
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
