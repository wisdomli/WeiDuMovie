package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.bean.VerstionBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：温浩
 * 时间：2018/11/30
 */
public class MyversionActivityPresenter extends AppDelegate{

    private TextView visition_text;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_latesedition;
    }

    @Override
    public void initData() {
        super.initData();
        visition_text = get(R.id.visition_text);
        String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
        int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
        Map<String, String> hashMapHead = new HashMap<>();
        Map<String, String> hashMap = new HashMap<>();
        hashMapHead.put("sessionId", sessionId);
        hashMapHead.put("userId", userId + "");
        hashMapHead.put("ak", "0110010010000");
        getString1(0, HttpUrl.VersionUrl,hashMap,hashMapHead);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        VerstionBean verstionBean = gson.fromJson(data, VerstionBean.class);
        String message = verstionBean.getMessage();
        String downloadUrl = verstionBean.getDownloadUrl();
        int flag = verstionBean.getFlag();
        if (flag==1){
            visition_text.setText(downloadUrl);
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
    }

    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
