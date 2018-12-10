package com.bw.movie.weidumovie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.mvp.presenter.BaseActivityPresenter;
import com.bw.movie.weidumovie.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {


    @Override
    public Class<MainActivityPresenter> getClassDelegate() {
        return MainActivityPresenter.class;
        //温浩
    }
}
