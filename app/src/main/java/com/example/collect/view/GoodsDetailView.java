package com.example.collect.view;

import com.example.collect.base.BaseView;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;

public interface GoodsDetailView extends BaseView {
    void setData(GoodsDetail goodsDetail);

    void show(String msg);

    void setDataRelate(GoodsDetailRelate goodsDetailRelate);

    void setAddCart(AddCart addCart);

    void setCartData(AddCart addCart);
}
