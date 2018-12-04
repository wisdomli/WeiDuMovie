package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.MainActivity;
import com.bw.movie.WeiDuMovie.fragment.NearbyCinemaFragment;
import com.bw.movie.WeiDuMovie.fragment.RecommendCinemaFragment;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.NetWork;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <影院页面>
 * 2018/11/28
 **/
public class CinemaFragmentPresenter extends AppDelegate implements View.OnClickListener {
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager Cinema_ViewPager;
    private Button btn_Recommend, btn_nearby;
    private View networkView;

    @Override
    public int getLayoutId() {
        return R.layout.cinema_fragment;
    }

    @Override
    public void initData() {
        super.initData();
        // 判断有网无网
        networkView = get(R.id.networkView);
        btn_Recommend = (Button) get(R.id.btn_Recommend);
        btn_nearby = (Button) get(R.id.btn_nearby);
        setOnClikLisener(this, R.id.btn_Recommend, R.id.btn_nearby);
        fragments.add(new RecommendCinemaFragment());
        fragments.add(new NearbyCinemaFragment());
        Cinema_ViewPager = (ViewPager) get(R.id.Cinema_ViewPager);
        FragmentManager manager = ((MainActivity) context).getSupportFragmentManager();
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(manager);
        Cinema_ViewPager.setAdapter(fragmentPagerAdapter);

        // 默认显示
        btn_Recommend.setTextColor(Color.WHITE);
        btn_Recommend.setBackgroundResource(R.drawable.cinema_btn);
        btn_nearby.setTextColor(Color.BLACK);
        btn_nearby.setBackgroundResource(R.drawable.cinema_btn_f);
        Cinema_ViewPager.setCurrentItem(0);
    }
    // 点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Recommend:
                btn_Recommend.setTextColor(Color.WHITE);
                btn_Recommend.setBackgroundResource(R.drawable.cinema_btn);
                btn_nearby.setTextColor(Color.BLACK);
                btn_nearby.setBackgroundResource(R.drawable.cinema_btn_f);
                Cinema_ViewPager.setCurrentItem(0);
                break;
            case R.id.btn_nearby:
                btn_nearby.setTextColor(Color.WHITE);
                btn_nearby.setBackgroundResource(R.drawable.cinema_btn);
                btn_Recommend.setTextColor(Color.BLACK);
                btn_Recommend.setBackgroundResource(R.drawable.cinema_btn_f);
                Cinema_ViewPager.setCurrentItem(1);
                break;
        }
    }




    private class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

        public FragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }


    public void onResume() {
      if (NetWork.isConnected(context)){
          networkView.setVisibility(View.GONE);
      }else {
          networkView.setVisibility(View.VISIBLE);
      }
    }
}
