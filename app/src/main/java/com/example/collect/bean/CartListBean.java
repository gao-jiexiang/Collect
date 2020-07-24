package com.example.collect.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CartListBean {
    /**
     * id : 250
     * user_id : 5
     * session_id : 1
     * goods_id : 1147045
     * goods_sn : 1147045
     * product_id : 225
     * goods_name : 清新趣粉系列居家地毯 灰黄条纹
     * market_price : 599
     * retail_price : 599
     * number : 10
     * goods_specifition_name_value :
     * goods_specifition_ids :
     * checked : 1
     * list_pic_url : http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png
     */

    @Id
    private long id;
    private int user_id;
    private String session_id;
    private int goods_id;
    private String goods_sn;
    private int product_id;
    private String goods_name;
    private int market_price;
    private int retail_price;
    private int number;
    private String goods_specifition_name_value;
    private String goods_specifition_ids;
    private int checked;//下单状态复选框的控制数据
    private String list_pic_url;
    private boolean editChecked;//复选框
    private boolean isServerDelete;//服务器是否需要删除
    @Generated(hash = 993447025)
    public CartListBean(long id, int user_id, String session_id, int goods_id,
            String goods_sn, int product_id, String goods_name, int market_price,
            int retail_price, int number, String goods_specifition_name_value,
            String goods_specifition_ids, int checked, String list_pic_url,
            boolean editChecked, boolean isServerDelete) {
        this.id = id;
        this.user_id = user_id;
        this.session_id = session_id;
        this.goods_id = goods_id;
        this.goods_sn = goods_sn;
        this.product_id = product_id;
        this.goods_name = goods_name;
        this.market_price = market_price;
        this.retail_price = retail_price;
        this.number = number;
        this.goods_specifition_name_value = goods_specifition_name_value;
        this.goods_specifition_ids = goods_specifition_ids;
        this.checked = checked;
        this.list_pic_url = list_pic_url;
        this.editChecked = editChecked;
        this.isServerDelete = isServerDelete;
    }
    @Generated(hash = 395015845)
    public CartListBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getUser_id() {
        return this.user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getSession_id() {
        return this.session_id;
    }
    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
    public int getGoods_id() {
        return this.goods_id;
    }
    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }
    public String getGoods_sn() {
        return this.goods_sn;
    }
    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }
    public int getProduct_id() {
        return this.product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getGoods_name() {
        return this.goods_name;
    }
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public int getMarket_price() {
        return this.market_price;
    }
    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }
    public int getRetail_price() {
        return this.retail_price;
    }
    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }
    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getGoods_specifition_name_value() {
        return this.goods_specifition_name_value;
    }
    public void setGoods_specifition_name_value(String goods_specifition_name_value) {
        this.goods_specifition_name_value = goods_specifition_name_value;
    }
    public String getGoods_specifition_ids() {
        return this.goods_specifition_ids;
    }
    public void setGoods_specifition_ids(String goods_specifition_ids) {
        this.goods_specifition_ids = goods_specifition_ids;
    }
    public int getChecked() {
        return this.checked;
    }
    public void setChecked(int checked) {
        this.checked = checked;
    }
    public String getList_pic_url() {
        return this.list_pic_url;
    }
    public void setList_pic_url(String list_pic_url) {
        this.list_pic_url = list_pic_url;
    }
    public boolean getEditChecked() {
        return this.editChecked;
    }
    public void setEditChecked(boolean editChecked) {
        this.editChecked = editChecked;
    }
    public boolean getIsServerDelete() {
        return this.isServerDelete;
    }
    public void setIsServerDelete(boolean isServerDelete) {
        this.isServerDelete = isServerDelete;
    }
}