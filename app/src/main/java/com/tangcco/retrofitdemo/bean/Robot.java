package com.tangcco.retrofitdemo.bean;

/**
 * Created by hhh on 2017/3/18.
 */

public class Robot {
    @Override
    public String toString() {
        return "Robot{" +
                "reason='" + reason + '\'' +
                ", result='" + result + '\'' +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    private String reason;
    private String result;
    private int error_code;
}
