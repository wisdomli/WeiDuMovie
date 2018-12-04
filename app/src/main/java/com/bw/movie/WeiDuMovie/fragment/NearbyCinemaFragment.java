package com.bw.movie.WeiDuMovie.fragment;

import com.bw.movie.WeiDuMovie.mvp.presenter.BaseFragmentPresenter;
import com.bw.movie.WeiDuMovie.presenter.NearbyCinemaFragmentPresenter;

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
