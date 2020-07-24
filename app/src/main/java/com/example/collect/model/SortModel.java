package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.SortTabBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class SortModel extends BaseModel {
    public void getTab(ResultCallBack<SortTabBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                .getApiService()
                .getSortTab()
                .compose(RxUtils.<SortTabBean>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<SortTabBean>() {
                    @Override
                    protected void onSuccess(SortTabBean sortTabBean) {
                        callBack.onSuccess(sortTabBean);
                    }
                })
        );
    }
}
