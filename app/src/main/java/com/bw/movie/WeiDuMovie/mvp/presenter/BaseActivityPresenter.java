package com.bw.movie.WeiDuMovie.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bw.movie.WeiDuMovie.Immersive.UltimateBar;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

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
        // 沉浸式
        UltimateBar.newImmersionBuilder()
                .applyNav(false)   // 是否应用到导航栏
                .build(this)
                .apply();
    }
    public void initWeiGht() {}


}
