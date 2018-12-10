package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.MyFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class MyFragment extends BaseFragmentPresenter<MyFragmentPresenter>{
    @Override
    public Class<MyFragmentPresenter> getClassDelegate() {
        return MyFragmentPresenter.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
