package com.example.collect.presenter;

import android.util.Log;

import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.GoodsResult;
import com.example.collect.model.GoodsModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.GoodsListView;


public class GoodsListPresenter extends BasePresenter<GoodsListView> {
    private GoodsModel model;
    @Override
    protected void initModel() {
        model = new GoodsModel();
        addModel(model);
    }

    public void getData(int id) {
        model.getData(id, new ResultCallBack<GoodsResult>() {
            @Override
            public void onSuccess(GoodsResult goodsResult) {
                    mView.setData(goodsResult);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
