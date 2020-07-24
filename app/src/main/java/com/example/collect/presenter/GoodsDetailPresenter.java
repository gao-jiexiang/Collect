package com.example.collect.presenter;

import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;
import com.example.collect.model.GoodsDetailModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.GoodsDetailView;

public class GoodsDetailPresenter extends BasePresenter<GoodsDetailView> {
    private GoodsDetailModel goodsDetailModel;

    @Override
    protected void initModel() {
        goodsDetailModel = new GoodsDetailModel();
        addModel(goodsDetailModel);
    }

    public void getData(int id) {
        goodsDetailModel.getData(id, new ResultCallBack<GoodsDetail>() {
            @Override
            public void onSuccess(GoodsDetail goodsDetail) {
                mView.setData(goodsDetail);
            }

            @Override
            public void onFail(String msg) {
                mView.show(msg);

            }
        });
    }

    public void getDataRelate(int id) {
        goodsDetailModel.getDataRelate(id, new ResultCallBack<GoodsDetailRelate>() {
            @Override
            public void onSuccess(GoodsDetailRelate goodsDetailRelate) {
                mView.setDataRelate(goodsDetailRelate);
            }

            @Override
            public void onFail(String msg) {
                mView.show(msg);

            }
        });
    }

    public void addCart( int goods_id, int number, int productId) {
        goodsDetailModel.addCart(goods_id,number,productId, new ResultCallBack<AddCart>() {
            @Override
            public void onSuccess(AddCart addCart) {
                if (addCart.getErrno()== Constants.SUCCESS_CODE){
                    mView.setAddCart(addCart);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void getCartData() {
        goodsDetailModel.getCartData(new ResultCallBack<AddCart>() {
            @Override
            public void onSuccess(AddCart addCart) {
                if (addCart.getErrno() ==Constants.SUCCESS_CODE){
                    mView.setCartData(addCart);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
