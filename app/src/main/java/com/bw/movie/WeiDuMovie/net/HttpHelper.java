package com.bw.movie.WeiDuMovie.net;

import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 作者:李自强
 * <联网工具类>
 * 2018/11/27
 **/
public class HttpHelper {
    private final BaseService mbaseService;
    public HttpHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mbaseService = retrofit.create(BaseService.class);
    }

    public HttpHelper get(String url, Map<String, String> map) {
        mbaseService.get(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return this;
    }


    public HttpHelper post(String url, Map<String, String> map) {
        mbaseService.get(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return this;
    }


    private Observer observer = new Observer<ResponseBody>() {


        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(ResponseBody body) {
            try {
                lsener.suecss(body.string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(Throwable e) {
         lsener.erorr(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    };

    private HttpLsener lsener;
    public void rosout(HttpLsener lsener){
        this.lsener = lsener;
    }

    public interface HttpLsener{
        void suecss(String data);
        void erorr(String erorr);
    }

}
