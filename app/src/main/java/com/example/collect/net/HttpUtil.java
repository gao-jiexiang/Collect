package com.example.collect.net;

import android.util.Log;

import com.example.collect.base.Constants;
import com.example.collect.util.SpUtil;
import com.example.collect.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {
    //rxjava+retrofit+ok
    //单例
    //数据缓存,日志,请求头(开发一般是固定的,token...)
    //token,身份令牌

    private final Retrofit mRetrofit;
    private volatile ApiService mApiService;

    private HttpUtil() {
        //获取一个OkHttpClient
        OkHttpClient mOkHttpClient = getOkHttpClient();
        //获取到一个Retrofit.Builder
        mRetrofit = getRetrofit(mOkHttpClient);
    }


    //获取数据加载的Retrofit
    private Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)//使用自定义的更强大的ok代替原来的弱鸡ok
                .baseUrl(Constants.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static volatile HttpUtil instance;

    public static HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    instance = new HttpUtil();
                }
            }
        }
        return instance;
    }



    /**
     * 固定模板
     * 创建带缓存的OkhttpClient
     * 1.添加了缓存
     * 2.添加了日志拦截器
     *
     * @return
     */
    private OkHttpClient getOkHttpClient() {
        //设置本地缓存文件
        File cacheFile = new File(Constants.PATH_CACHE);
        //设置缓存文件大小
        //1 M = 1024Kb = 1024 * 1024 byte
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cache(cache)//缓存
                .addInterceptor(new MyCacheinterceptor())
                //添加了请求头拦截器之后,所有使用网络框架的网络请求都会添加拦截器中的请求头
                //不需要请求头的也加了请求头,是不影响请求
                .addInterceptor(new HeadersInterceptor())
                .addNetworkInterceptor(new MyCacheinterceptor())
                //设置写入时间
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                //设置错误重连
                .retryOnConnectionFailure(true);
        //如果是debug状态(码农调试应用),添加日志拦截器,
        // 如果是正式上线了isDebug该false,就不打印日志
        if (Constants.isDebug) {
            builder.addInterceptor(new LoggingInterceptor());
        }
        return builder.build();
    }


    /**
     * 请求的修改设置
     */
    public static class HeadersInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            String token = (String) SpUtil.getParam(Constants.TOKEN,"");
            //LogUtils.print("token:"+token);
            Request request = chain.request().newBuilder()
                    .addHeader("Client-Type", "ANDROID")
                    .addHeader("X-Nideshop-Token",
                            token)
                    .build();
            return chain.proceed(request);
        }
    }

    /**
     * 固定模板
     */
    private class MyCacheinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上
            // 面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!SystemUtil.isNetworkConnected()) {
                request = request
                        .newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)//强制使用缓存
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (SystemUtil.isNetworkConnected()) {
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                //s秒
                int maxStale = 60 * 60 * 24;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，
                        // 想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached," +
                                " max-age=" + maxStale)
                        .build();
            }

        }
    }

    //日志拦截器
    public class LoggingInterceptor implements Interceptor {
        private static final String TAG = "LoggingInterceptor";

        @Override
        public Response intercept(Chain chain) throws IOException {
            //拦截链对象
            Request request = chain.request();
            //Object...args ,...是可变参数,可以理解成数组
            //String.format()第一个参数是格式,后面的参数是替代参数,需要将里面的%s的位置使用
            //后面的参数给替代掉
            //"发送请求地址:"+request.url()+"%n请求头:"+request.header();
            Log.d(TAG, String.format("发送请求地址:%s%n请求头:%s", request.url(),
                    request.headers()));
            long startTime = System.currentTimeMillis();
            //递归+循环的方式把所有的拦截器串联起来,并获取响应结果
            Response response = chain.proceed(request);
            long endTime = System.currentTimeMillis();

            //这里不能直接使用response.body().string()的方式输出日志
            //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
            //个新的response给应用层处理
            ResponseBody responseBody = response.peekBody(1024 * 1024);


            Log.d(TAG, String.format("耗时:%s%n收到来自:%s的结果:%n%s",
                    (endTime - startTime) + "ms", response.request().url(), responseBody.string()));

            return response;
        }
    }

    //创建Retrofit请求数据接口,以前这么写是因为baseurl不固定
    /*public synchronized <T> T getApiserver(String baseUrl, Class<T> tClass){
        return mRetrofitBuilder.baseUrl(baseUrl).build().create(tClass);
    }*/

    public ApiService getApiService() {
        if (mApiService == null) {
            synchronized (HttpUtil.class) {
                if (mApiService == null) {
                    mApiService = mRetrofit.create(ApiService.class);
                }
            }
        }
        return mApiService;
    }
}
