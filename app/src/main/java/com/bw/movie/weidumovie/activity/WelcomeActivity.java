package com.bw.movie.weidumovie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.movie.weidumovie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 欢迎页
 */
public class WelcomeActivity extends AppCompatActivity {
    private List<Integer> imgList = new ArrayList<>();
    private Button btn_Welcome;
    private SharedPreferences cofig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imgList.add(R.drawable.welcom1);
        imgList.add(R.drawable.welcome2);
        imgList.add(R.drawable.welcome3);
        imgList.add(R.drawable.welcome4);

        ViewPager WelcomeViewPager = findViewById(R.id.WelcomeViewPager);
        WelcomeViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = new ImageView(WelcomeActivity.this);
                imageView.setImageResource(imgList.get(position));
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View)object);
            }
        });

        WelcomeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i == 3){
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    cofig.edit().putBoolean("0", true).commit();
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        // 获取SharedPreferences 存储 点击状态
        cofig = getSharedPreferences("cofig", 0);
        boolean b = cofig.getBoolean("0", false);
        // 进行判断
        if (b) {
           startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    }

}
