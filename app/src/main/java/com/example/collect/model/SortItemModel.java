package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.SortItemBean;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class SortItemModel extends BaseModel {
    public void getData(int id, ResultCallBack<SortItemBean> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .getSortItem(id)
                        .compose(RxUtils.<SortItemBean>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<SortItemBean>() {
                            @Override
                            protected void onSuccess(SortItemBean sortItemBean) {
                                callBack.onSuccess(sortItemBean);
                            }
                        })
        );
    }
}
