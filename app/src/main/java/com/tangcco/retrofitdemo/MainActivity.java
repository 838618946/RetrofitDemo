package com.tangcco.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tangcco.retrofitdemo.bean.Robot;
import com.tangcco.retrofitdemo.net.IGitHubBeanAPI;
import com.tangcco.retrofitdemo.bean.User;
import com.tangcco.retrofitdemo.net.IRobotServiceApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Get(View view) {
        new Thread() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                IGitHubBeanAPI users = retrofit.create(IGitHubBeanAPI.class);
                Call<List<User>> call = users.getUsersData("octocat");
                try {
                    List<User> list = call.execute().body();
                    for (User user : list) {
                        Log.e(TAG, "run: " + user.toString());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void RxJava(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        IRobotServiceApi rot = retrofit.create(IRobotServiceApi.class);
        Observable<Robot> obser = rot.getRobotDatas("你好啊", "c42e8ba0246500486843f471dd36ab28");
        obser.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Robot>() {
                    @Override
                    public void call(Robot robot) {
                        Log.e(TAG, "call: " + robot.toString());
                    }
                });
    }
}
