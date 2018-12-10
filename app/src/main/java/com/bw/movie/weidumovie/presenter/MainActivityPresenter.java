package com.bw.movie.weidumovie.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.MainActivity;
import com.bw.movie.weidumovie.fragment.CinemaFragment;
import com.bw.movie.weidumovie.fragment.FilmFragment;
import com.bw.movie.weidumovie.fragment.MyFragment;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李自强
 * <整体布局>
 * 2018/11/27
 **/
public class MainActivityPresenter extends AppDelegate implements View.OnClickListener {
    private ImageView btn_film, btn_cinema, btn_my;
    private int wheight;
    private FrameLayout min_frgament;
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager min_ViewPager;
    private boolean isClik = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        btn_film = (ImageView) get(R.id.btn_film);
        btn_cinema = (ImageView) get(R.id.btn_cinema);
        btn_my = (ImageView) get(R.id.btn_my);

        setOnClikLisener(this, R.id.btn_film, R.id.btn_cinema, R.id.btn_my);
        Display defaultDisplay = ((MainActivity) context).getWindowManager().getDefaultDisplay();
        wheight = defaultDisplay.getWidth();
        FragmentManager manager = ((MainActivity) context).getSupportFragmentManager();
        FragmentPager fragmentPager = new FragmentPager(manager);
        min_ViewPager = (ViewPager) get(R.id.min_ViewPager);

        fragments.add(new FilmFragment());
        fragments.add(new CinemaFragment());
        fragments.add(new MyFragment());
        min_ViewPager.setAdapter(fragmentPager);

        setSizeMax(btn_film);
        setSizeMin(btn_cinema);
        setSizeMin(btn_my);
        btn_film.setImageResource(R.drawable.com_icon_film_selected);
        btn_cinema.setImageResource(R.drawable.com_icon_cinema_default);
        btn_my.setImageResource(R.drawable.com_icon_my_default);
        min_ViewPager.setCurrentItem(0);
        // ViewPager缓存数据
        min_ViewPager.setOffscreenPageLimit(3);
        min_ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {


            }
            // 选中状态
            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    setSizeMax(btn_film);
                    setSizeMin(btn_cinema);
                    setSizeMin(btn_my);
                    btn_film.setImageResource(R.drawable.com_icon_film_selected);
                    btn_cinema.setImageResource(R.drawable.com_icon_cinema_default);
                    btn_my.setImageResource(R.drawable.com_icon_my_default);
                } else if (i == 1) {
                    setSizeMin(btn_film);
                    setSizeMin(btn_my);
                    setSizeMax(btn_cinema);
                    btn_cinema.setImageResource(R.drawable.com_icon_cinema_selected);
                    btn_my.setImageResource(R.drawable.com_icon_my_default);
                    btn_film.setImageResource(R.drawable.com_icon_film_fault);
                } else if (i == 2) {
                    setSizeMin(btn_film);
                    setSizeMin(btn_cinema);
                    setSizeMax(btn_my);
                    btn_my.setImageResource(R.drawable.com_icon_my_selected);
                    btn_cinema.setImageResource(R.drawable.com_icon_cinema_default);
                    btn_film.setImageResource(R.drawable.com_icon_film_fault);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private class FragmentPager extends FragmentPagerAdapter {
        public FragmentPager(FragmentManager fm) {
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

    public void setSizeMax(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = 70 * (wheight / 2) / 160;
        layoutParams.width = 70 * (wheight / 2) / 160;
    }

    public void setSizeMin(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = 60 * (wheight / 2) / 160;
        layoutParams.width = 60 * (wheight / 2) / 160;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_film:

                setSizeMax(btn_film);
                setSizeMin(btn_cinema);
                setSizeMin(btn_my);
                btn_film.setImageResource(R.drawable.com_icon_film_selected);
                btn_cinema.setImageResource(R.drawable.com_icon_cinema_default);
                btn_my.setImageResource(R.drawable.com_icon_my_default);
                min_ViewPager.setCurrentItem(0);


                break;
            case R.id.btn_cinema:
                setSizeMin(btn_film);
                setSizeMin(btn_my);
                setSizeMax(btn_cinema);
                btn_cinema.setImageResource(R.drawable.com_icon_cinema_selected);
                btn_my.setImageResource(R.drawable.com_icon_my_default);
                btn_film.setImageResource(R.drawable.com_icon_film_fault);
                min_ViewPager.setCurrentItem(1);
                break;
            case R.id.btn_my:
                setSizeMin(btn_film);
                setSizeMin(btn_cinema);
                setSizeMax(btn_my);
                btn_my.setImageResource(R.drawable.com_icon_my_selected);
                btn_cinema.setImageResource(R.drawable.com_icon_cinema_default);
                btn_film.setImageResource(R.drawable.com_icon_film_fault);
                min_ViewPager.setCurrentItem(2);
                break;
        }
    }
}
