package com.bw.movie.WeiDuMovie.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public interface BaseService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String,String> map);
    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String,String> map);
}
