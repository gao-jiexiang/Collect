package com.example.collect.bean;

import java.util.List;

public class AddCart {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":250,"user_id":5,"session_id":"1","goods_id":1147045,"goods_sn":"1147045","product_id":225,"goods_name":"清新趣粉系列居家地毯 灰黄条纹","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png"},{"id":255,"user_id":5,"session_id":"1","goods_id":1147046,"goods_sn":"1147046","product_id":226,"goods_name":"清新趣粉系列居家地毯 条纹间粉","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png"},{"id":283,"user_id":5,"session_id":"1","goods_id":1147047,"goods_sn":"1147047","product_id":227,"goods_name":"简约知性系列居家地毯 蓝粉拼接","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png"},{"id":290,"user_id":5,"session_id":"1","goods_id":1147048,"goods_sn":"1147048","product_id":228,"goods_name":"简约知性系列居家地毯 蓝灰格","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png"},{"id":297,"user_id":5,"session_id":"1","goods_id":1116033,"goods_sn":"1116033","product_id":171,"goods_name":"多功能人体工学转椅","market_price":1399,"retail_price":1399,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/f1dbf1d9967c478ee6def81ed40734a2.png"}],"cartTotal":{"goodsCount":30,"goodsAmount":20930,"checkedGoodsCount":30,"checkedGoodsAmount":20930}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cartList : [{"id":250,"user_id":5,"session_id":"1","goods_id":1147045,"goods_sn":"1147045","product_id":225,"goods_name":"清新趣粉系列居家地毯 灰黄条纹","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png"},{"id":255,"user_id":5,"session_id":"1","goods_id":1147046,"goods_sn":"1147046","product_id":226,"goods_name":"清新趣粉系列居家地毯 条纹间粉","market_price":599,"retail_price":599,"number":10,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png"},{"id":283,"user_id":5,"session_id":"1","goods_id":1147047,"goods_sn":"1147047","product_id":227,"goods_name":"简约知性系列居家地毯 蓝粉拼接","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png"},{"id":290,"user_id":5,"session_id":"1","goods_id":1147048,"goods_sn":"1147048","product_id":228,"goods_name":"简约知性系列居家地毯 蓝灰格","market_price":559,"retail_price":559,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png"},{"id":297,"user_id":5,"session_id":"1","goods_id":1116033,"goods_sn":"1116033","product_id":171,"goods_name":"多功能人体工学转椅","market_price":1399,"retail_price":1399,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/f1dbf1d9967c478ee6def81ed40734a2.png"}]
         * cartTotal : {"goodsCount":30,"goodsAmount":20930,"checkedGoodsCount":30,"checkedGoodsAmount":20930}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 30
             * goodsAmount : 20930
             * checkedGoodsCount : 30
             * checkedGoodsAmount : 20930
             */

            private int goodsCount;
            private int goodsAmount;
            private int checkedGoodsCount;
            private int checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public int getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(int checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

    }
}
