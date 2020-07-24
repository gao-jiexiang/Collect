package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.LoginBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class LoginModel extends BaseModel {
    public void login(String name, String pw, ResultCallBack<LoginBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                .getApiService()
                .login(name,pw)
                .compose(RxUtils.<LoginBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<LoginBean>() {
                    @Override
                    protected void onSuccess(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
                    }
                })
        );
    }
}
