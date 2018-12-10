package com.bw.movie.weidumovie.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.weidumovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public abstract class BaseFragmentPresenter <T extends AppDelegate>extends Fragment{
    public   T delegate;

    public abstract Class<T> getClassDelegate();

    public BaseFragmentPresenter(){

        try {
            delegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        delegate.create(inflater,container,savedInstanceState);
        return delegate.rootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        delegate.getContext(getActivity());
        initWeight();
        delegate.initData();
    }

    public void initWeight() {
    }
}
