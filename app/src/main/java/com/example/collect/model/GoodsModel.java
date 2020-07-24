package com.example.collect.model;

import android.util.Log;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.GoodsResult;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class GoodsModel extends BaseModel {

    public void getData(int id, ResultCallBack<GoodsResult> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                .getApiService().
                        getGoods(id,1,100)
                        .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<GoodsResult>() {
                    @Override
                    protected void onSuccess(GoodsResult goodsResult) {
                            callBack.onSuccess(goodsResult);
                    }

                    @Override
                    protected void onFail(String err) {
                        super.onFail(err);
                        Log.i("错误信息", "onFail: "+err);
                    }


                })
        );
    }
}
