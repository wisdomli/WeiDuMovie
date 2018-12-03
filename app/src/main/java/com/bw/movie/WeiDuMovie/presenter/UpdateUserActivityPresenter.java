package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.UpdateUserActivity;
import com.bw.movie.WeiDuMovie.bean.UpdateBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * 作者：温浩
 * 时间：2018/12/2
 */
public class UpdateUserActivityPresenter extends AppDelegate {

    private EditText updateuser_edit;
    private TextView updateuser_text;
    private HashMap<String, String> hashMap;
    private HashMap<String, String> hashMapHead;
    private UpdateBean updateBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_user;
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        updateBean = gson.fromJson(data, UpdateBean.class);
        String status = updateBean.getStatus();
        String message = updateBean.getMessage();
        if (status.equals("0000")){
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
            ((UpdateUserActivity)context).finish();
        }else {
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void initData() {
        super.initData();
        updateuser_edit = get(R.id.updateuser_edit);
        updateuser_text = get(R.id.updateuser_text);
        hashMap = new HashMap<>();
        hashMapHead = new HashMap<>();
        updateuser_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sessionId = context.getSharedPreferences("config", 0).getString("sessionId", "").toString();
                int userId = context.getSharedPreferences("config", 0).getInt("userId", 0);
                String email = context.getSharedPreferences("config", 0).getString("email", "").toString();
                int sex = context.getSharedPreferences("config", 0).getInt("sex", 0);
                String nickName = updateuser_edit.getText().toString();

                if (nickName.isEmpty()){
                    Toast.makeText(context,"请输入内容",Toast.LENGTH_SHORT).show();
                }else if (!nickName.isEmpty()){
                    hashMap.put("nickName",nickName);
                    hashMap.put("email",email);
                    hashMap.put("sex",sex+"");
                    hashMapHead.put("sessionId",sessionId);
                    hashMapHead.put("userId",userId+"");
                    hashMapHead.put("Content-Type","application/x-www-form-urlencoded");
                    postString1(0, HttpUrl.UpdateUrl,hashMap,hashMapHead);
                }
            }
        });
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    public void onResume() {
        String nickName = context.getSharedPreferences("config", 0).getString("nickName", "").toString();

        if (nickName.isEmpty()) {
            updateuser_edit.setText("");
        } else {
            updateuser_edit.setText(nickName);
        }
    }
}
