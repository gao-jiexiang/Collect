package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.AddCart;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class CartModel extends BaseModel {
    public void getCartData(ResultCallBack<AddCart> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .getCartData()
                        .compose(RxUtils.<AddCart>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<AddCart>() {
                            @Override
                            protected void onSuccess(AddCart goodsDetailRelate) {
                                callBack.onSuccess(goodsDetailRelate);
                            }
                        })
        );
    }

    public void updateNumber(int productId, int goodsId, int number, long id, ResultCallBack<AddCart> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .updateGoodsNumber(productId,goodsId,number,id)
                        .compose(RxUtils.<AddCart>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<AddCart>() {
                            @Override
                            protected void onSuccess(AddCart goodsDetailRelate) {
                                callBack.onSuccess(goodsDetailRelate);
                            }
                        })
        );
    }

    public void deleteGoods(String productIds, ResultCallBack<AddCart> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .deleteGoods(productIds)
                        .compose(RxUtils.<AddCart>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<AddCart>() {
                            @Override
                            protected void onSuccess(AddCart goodsDetailRelate) {
                                callBack.onSuccess(goodsDetailRelate);
                            }
                        })
        );
    }
}
