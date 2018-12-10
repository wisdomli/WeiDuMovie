package com.bw.movie.weidumovie.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.weidumovie.net.HttpHelper;

import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public abstract class AppDelegate implements IDelegate {

    private View rootView;

    @Override
    public void initData() {
    }

    private SparseArray<View> Views = new SparseArray<>();

    public <T extends View> T get(int id) {
        T view = (T) Views.get(id);
        if (view == null) {
            view = rootView.findViewById(id);
            Views.put(id, view);
        }
        return view;
    }

    public void setOnClikLisener(View.OnClickListener lisener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(lisener);
        }
    }

    @Override
    public void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        rootView = inflater.inflate(getLayoutId(), viewGroup, false);
    }


    public abstract int getLayoutId();

    @Override
    public View rootView() {
        return rootView;
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        this.context = context;
    }

    // get请求
    public void getString(final int type, String url, Map<String, String> map) {
        new HttpHelper().get(url, map).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                suecssString(type, data);
            }

            @Override
            public void erorr(String erorr) {
                erorrString(erorr);
            }
        });
    }

    public void getString1(final int type, String url, Map<String, String> map,Map<String,String> mapHead) {
        new HttpHelper().get1(url, map,mapHead).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                suecssString(type, data);
            }

            @Override
            public void erorr(String erorr) {
                erorrString(erorr);
            }
        });
    }

    // post请求
    public void postString(final int type, String url, Map<String, String> map) {
        new HttpHelper().post(url, map).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                suecssString(type, data);
            }

            @Override
            public void erorr(String erorr) {
                erorrString(erorr);
            }
        });
    }

    public void postString1(final int type,String url,Map<String,String> map,Map<String,String> mapHead){
        new HttpHelper().post1(url,map,mapHead).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                suecssString(type, data);
            }

            @Override
            public void erorr(String erorr) {
                erorrString(erorr);
            }
        });
    }


    public void suecssString(int type, String data) {
    }

    public void erorrString(String erorr) {
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {}


}
