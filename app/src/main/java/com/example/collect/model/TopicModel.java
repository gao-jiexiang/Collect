package com.example.collect.model;


import com.example.collect.base.BaseModel;
import com.example.collect.bean.TopicBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class TopicModel extends BaseModel {
    public void getTopic(int page, int size, ResultCallBack<TopicBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .getTopic(page,size)
                        .compose(RxUtils.<TopicBean>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<TopicBean>() {
                            @Override
                            protected void onSuccess(TopicBean topicBean) {
                                callBack.onSuccess(topicBean);
                            }
                        })


        );
    }
}
