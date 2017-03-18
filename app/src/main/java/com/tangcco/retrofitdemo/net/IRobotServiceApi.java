package com.tangcco.retrofitdemo.net;

import com.tangcco.retrofitdemo.bean.Robot;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hhh on 2017/3/18.
 */

public interface IRobotServiceApi {
    @GET("robot/index")
    Observable<Robot> getRobotData(@Query("info") String info, @Query("key") String key);

    @POST("robot/index")
    Observable<Robot> getRobotDatas(@Query("info") String info, @Query("key") String key);
}
