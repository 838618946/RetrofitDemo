package com.tangcco.retrofitdemo.net;

import com.tangcco.retrofitdemo.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hhh on 2017/3/18.
 */

public interface IGitHubBeanAPI {
    @GET("users/{name}/repos")
    Call<List<User>> getUsersData(@Path("name") String name);
}
