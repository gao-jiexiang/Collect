package com.example.collect.presenter;


import com.example.collect.base.BaseApp;
import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.CartListBean;
import com.example.collect.db.CartListBeanDao;
import com.example.collect.model.CartModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.util.LogUtil;
import com.example.collect.view.CartView;

import java.util.ArrayList;
import java.util.List;

public class CartPresenter extends BasePresenter<CartView> {

    private CartModel cartModel;
    private CartListBeanDao cartListBeanDao;

    @Override
    protected void initModel() {
        cartModel = new CartModel();
        addModel(cartModel);
        cartListBeanDao = BaseApp.sContext.getDaoSession().getCartListBeanDao();
    }

    public void getCartData() {
        cartModel.getCartData(new ResultCallBack<AddCart>() {
            @Override
            public void onSuccess(AddCart addCart) {
                if (addCart.getErrno()== Constants.SUCCESS_CODE){
                    mView.setCardData(addCart);

                    //将数据添加到数据库
                    if (addCart.getData().getCartList() !=null && addCart.getData().getCartList().size()>0){
                        cartListBeanDao.insertOrReplaceInTx(addCart.getData().getCartList());
                    }
                    LogUtil.print("数据库size："+cartListBeanDao.queryBuilder().list().size());
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void updateNumber(int productId, int goodsId, int number, long id) {
        cartModel.updateNumber(productId,goodsId,number,id, new ResultCallBack<AddCart>() {
            @Override
            public void onSuccess(AddCart addCart) {

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void deleteGoods(ArrayList<Integer> ids) {
        StringBuilder productIds = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            productIds.append(ids.get(i)+",");
        }
        cartModel.deleteGoods(productIds.toString(),new ResultCallBack<AddCart>() {
            @Override
            public void onSuccess(AddCart addCart) {
                //通知v层晒新界面
                ///删除的时候，ui不会等网络数据的时候
                //删除成功
                deleteSuccess(ids);


            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    private void deleteSuccess(ArrayList<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            List<CartListBean> list = cartListBeanDao.queryBuilder().where(CartListBeanDao.Properties.Product_id.eq
                    (ids.get(i))).list();
            if (list != null && list.size() > 0) {
                cartListBeanDao.deleteInTx(list);
            }
        }
    }
}
