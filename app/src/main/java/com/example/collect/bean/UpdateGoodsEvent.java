package com.example.collect.bean;

public class UpdateGoodsEvent {
    public int productId;
    public int goodsId;
    public int number;
    public long id;

    public UpdateGoodsEvent(int productId, int goodsId, int number, long id) {
        this.productId = productId;
        this.goodsId = goodsId;
        this.number = number;
        this.id = id;
    }
}
