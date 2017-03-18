package com.tangcco.retrofitdemo.bean;

/**
 * Created by hhh on 2017/3/18.
 */

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String url;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
