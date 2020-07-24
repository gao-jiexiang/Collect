package com.example.collect.model;

import com.example.collect.base.BaseModel;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;
import com.example.collect.net.HttpUtil;
import com.example.collect.net.ResultCallBack;
import com.example.collect.net.ResultSubScriber;
import com.example.collect.net.RxUtils;

public class GoodsDetailModel extends BaseModel {
    public void getData(int id, ResultCallBack<GoodsDetail> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService().
                        getGoodsDetail(id)
                        .compose(RxUtils.<GoodsDetail>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<GoodsDetail>() {
                            @Override
                            protected void onSuccess(GoodsDetail goodsDetail) {
                                callBack.onSuccess(goodsDetail);
                            }
                        })
        );
    }

    public void getDataRelate(int id, ResultCallBack<GoodsDetailRelate> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                .getApiService()
                .getGoodsReleate(id)
                .compose(RxUtils.<GoodsDetailRelate>rxSchedulerHelper())
                .subscribeWith(new ResultSubScriber<GoodsDetailRelate>() {
                    @Override
                    protected void onSuccess(GoodsDetailRelate goodsDetailRelate) {
                        callBack.onSuccess(goodsDetailRelate);
                    }
                })
        );
    }

    public void addCart(int goods_id, int number, int productId, ResultCallBack<AddCart> callBack) {
        addDisposable(
                HttpUtil.getInstance()
                        .getApiService()
                        .addCart2(goods_id,number,productId)
                        .compose(RxUtils.<AddCart>rxSchedulerHelper())
                        .subscribeWith(new ResultSubScriber<AddCart>() {
                            @Override
                            protected void onSuccess(AddCart goodsDetailRelate) {
                                callBack.onSuccess(goodsDetailRelate);
                            }
                        })
        );
    }

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
}
