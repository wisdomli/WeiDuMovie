package com.bw.movie.WeiDuMovie.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
