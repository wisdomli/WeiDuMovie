package com.bw.movie.WeiDuMovie.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public abstract class AppDelegate implements IDelegate{

    private View rootView;

    @Override
    public void initData() {
    }

    private SparseArray<View> Views = new SparseArray<>();
    public <T extends View> T get(int id){
        T view = (T) Views.get(id);
        if (view == null){
            view = rootView.findViewById(id);
            Views.put(id,view);
        }
        return view;
    }

    public void setOnClikLisener(View.OnClickListener lisener,int... ids){
        if (ids == null){
            return;
        }
        for (int id : ids){
            get(id).setOnClickListener(lisener);
        }
    }

    @Override
    public void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
         rootView = inflater.inflate(getLayoutId(),viewGroup, false);
    }


    public abstract  int getLayoutId();
    @Override
    public View rootView() {
        return rootView;
    }
   private Context context;
    @Override
    public void getContext(Context context) {
    this.context = context;
    }



}
