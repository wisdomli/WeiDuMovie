package com.bw.movie.weidumovie.fragment;

import com.bw.movie.weidumovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.weidumovie.presenter.NearbyCinemaFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/11/30
 **/
public class NearbyCinemaFragment extends BaseFragmentPresenter<NearbyCinemaFragmentPresenter>{
    @Override
    public Class<NearbyCinemaFragmentPresenter> getClassDelegate() {
        return NearbyCinemaFragmentPresenter.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }
}
