package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MainActivity;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/11/28
 **/
public class MyFragmentPresenter extends AppDelegate {
    private int wheight;

    @Override
    public int getLayoutId() {
        return R.layout.my_fragmen;
    }

    @Override
    public void initData() {
        super.initData();
        Display defaultDisplay = ((MainActivity) context).getWindowManager().getDefaultDisplay();
        wheight = defaultDisplay.getWidth();
        RelativeLayout my_relativelayout = get(R.id.my_relativelayout);
        setWheight(my_relativelayout);
    }

    public void setWheight(RelativeLayout textView){
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        params.width = wheight-(24+24);
    }

    private  Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
