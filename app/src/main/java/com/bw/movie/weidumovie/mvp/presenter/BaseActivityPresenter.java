package com.bw.movie.weidumovie.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bw.movie.weidumovie.Immersive.UltimateBar;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public abstract class BaseActivityPresenter<T extends AppDelegate>extends AppCompatActivity {

    public   T delegate;

    public abstract Class<T> getClassDelegate();

    public BaseActivityPresenter(){
        try {
            delegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.create(getLayoutInflater(),null,savedInstanceState);
        setContentView(delegate.rootView());
        delegate.getContext(this);
        initWeiGht();
        delegate.initData();


    }
    public void initWeiGht() {}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        delegate.onActivityResult(requestCode, resultCode,data);
    }
}
