package com.example.collect.net;

import com.example.collect.R;
import com.example.collect.base.BaseApp;
import com.example.collect.util.ToastUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import retrofit2.HttpException;
import android.net.ParseException;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class ResultSubScriber<T> extends ResourceSubscriber<T> {

    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1002;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1003;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1004;
    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable e) {
        //对异常进行分类,不同的异常提示用户不同的信息
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
        } else {
            if (e != null) {
                onFail(e.toString());
            } else {
                onFail(BaseApp.getRes().getString(R.string.unknow_error));
            }
        }

    }

    private void onException(int unknownError) {
        String err = "";
        switch (unknownError) {
            case CONNECT_ERROR:
                err = BaseApp.getRes().getString(R.string.conn_error);
                onFail(err);
                break;

            case CONNECT_TIMEOUT:
                err = BaseApp.getRes().getString(R.string.conn_timeout);
                onFail(err);
                break;

            case BAD_NETWORK:
                err = BaseApp.getRes().getString(R.string.net_error);
                onFail(err);
                break;

            case PARSE_ERROR:
                err = BaseApp.getRes().getString(R.string.parse_error);
                onFail(err);
                break;

            default:
                err = BaseApp.getRes().getString(R.string.unknow_error);
                onFail(err);
                break;
        }
        ToastUtil.showToastShort(err);
    }

    //如果异常不做特殊处理的话,不需要再次复写这个方法
    //如果需要单独处理的异常,复写这个方法
    protected void onFail(String err){
        ToastUtil.showToastShort(err);
    };
    @Override
    public void onComplete() {

    }
}
