package com.example.collect.net;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
