package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.RegisterBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class RegistModel extends BaseModel {
    public void getData(String name, String pass, ResultCallBack<RegisterBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .register(name,pass)
                        .compose(RxUtils.<RegisterBean>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<RegisterBean>() {
                            @Override
                            protected void onSuccess(RegisterBean registBean) {
                                callBack.onSuccess(registBean);
                            }
                        })
        );
    }
}
