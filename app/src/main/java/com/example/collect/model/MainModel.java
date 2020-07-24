package com.example.collect.model;

import android.util.Log;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.MainBean;
import com.example.collect.bean.TopicBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

///网络框架:1.每次都要写的生成网络接口对象ApiService
//      2.切换线程
//      3.观察者
public class MainModel extends BaseModel {
    public void getData() {

        //rxjava+Retrofit
        /*ResourceSubscriber<TopicBean> resourceSubscriber = new Retrofit.Builder()
                .baseUrl(Constants.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTopic(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TopicBean>() {
                    //ResourceSubscriber 也是观察者的一种,是专门配合Flowable使用,是disposable的子类
                    @Override
                    public void onNext(TopicBean topicBean) {
                        Log.d("ResourceSubscriber", "onNext: "+topicBean.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("error", "onError: "+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

       /* ResultSubScriber<TopicBean> scriber = HttpUtil.getInstance()
                .getApiService()
                .getTopic(1, 10)
                .compose(RxUtils.<TopicBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<TopicBean>() {
                    @Override
                    protected void onSuccess(TopicBean topicBean) {
                        Log.d("tag", "onSuccess: " + topicBean);
                    }
                });
        addDisposable(scriber);*/

       //写法2
        addDisposable(HttpUtil.getInstance()
                .getApiService()
                .getTopic(1, 10)
                .compose(RxUtils.<TopicBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<TopicBean>() {
                    @Override
                    protected void onSuccess(TopicBean topicBean) {
                        Log.d("tag", "onSuccess: " + topicBean);
                    }
                })
        );
    }

    public void getDate(ResultCallBack<MainBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .getData()
                        .compose(RxUtils.<MainBean>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<MainBean>() {
                            @Override
                            protected void onSuccess(MainBean mainBean) {
                                callBack.onSuccess(mainBean);
                            }
                        })
        );
    }
}
