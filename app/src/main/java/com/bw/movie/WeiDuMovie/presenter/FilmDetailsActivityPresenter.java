package com.bw.movie.WeiDuMovie.presenter;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.WeiDuMovie.R;
import com.bw.movie.WeiDuMovie.activity.FilmDetailsActivity;
import com.bw.movie.WeiDuMovie.bean.FilmDetailsBean;
import com.bw.movie.WeiDuMovie.mvp.view.AppDelegate;
import com.bw.movie.WeiDuMovie.net.HttpUrl;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:李自强
 * <p>
 * 2018/12/2
 **/
public class FilmDetailsActivityPresenter extends AppDelegate implements View.OnClickListener {
    private SimpleDraweeView FilmDetails_img;
    private TextView filmDetails_title;
    private SimpleDraweeView filmDetails_img_Gaussfuzzy;

    @Override
    public int getLayoutId() {
        return R.layout.filmdetails;
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = ((FilmDetailsActivity) context).getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Map<String, String> map = new HashMap<>();
        map.put("movieId", movieId + "");
        getString(0, HttpUrl.MoviesDetailUrl, map);
        FilmDetails_img = (SimpleDraweeView) get(R.id.filmDetails_img);
        filmDetails_img_Gaussfuzzy = (SimpleDraweeView) get(R.id.filmDetails_img_Gaussfuzzy);
        filmDetails_title = (TextView) get(R.id.filmDetails_title);

        setOnClikLisener(this, R.id.filmDetails_btn_back,R.id.filmDetails_btn_Tickebuy);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        FilmDetailsBean filmDetailsBean = gson.fromJson(data, FilmDetailsBean.class);
        FilmDetailsBean.ResultBean result = filmDetailsBean.getResult();
        String imageUrl = result.getImageUrl();
        filmDetails_img_Gaussfuzzy.setImageURI(imageUrl);
//        showUrlBlur(filmDetails_img_Gaussfuzzy,imageUrl,1,1);
        FilmDetails_img.setImageURI(imageUrl);
        filmDetails_title.setText(result.getName());
    }

    //高斯模糊
    public  void showUrlBlur(SimpleDraweeView draweeView, String url, int iterations, int blurRadius) {
        try {
            Uri uri = Uri.parse(url);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setPostprocessor(new IterativeBoxBlurPostProcessor(iterations, blurRadius))
                    .build();
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setOldController(draweeView.getController())
                    .setImageRequest(request)
                    .build();
            draweeView.setController(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.filmDetails_btn_back:
                ((FilmDetailsActivity) context).finish();
                break;
            case R.id.filmDetails_btn_Tickebuy:
                Toast.makeText(context,"支付功能暂未实现",Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
