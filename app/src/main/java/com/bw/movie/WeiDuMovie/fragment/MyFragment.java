package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.MyFragmentPresenter;

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
}
