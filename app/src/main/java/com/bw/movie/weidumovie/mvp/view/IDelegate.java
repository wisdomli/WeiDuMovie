package com.bw.movie.weidumovie.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:李自强
 *初始化数据
 * 2018/11/27
 **/
public interface IDelegate {
    void initData();
    void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);
    View rootView();
    void getContext(Context context);
}
