package com.example.collect.bean;

import java.util.List;

public class GoodsDetailRelate {


    /**
     * errno : 0
     * errmsg :
     * data : {"goodsList":[{"id":1006002,"name":"轻奢纯棉刺绣水洗四件套","list_pic_url":"http://yanxuan.nosdn.127.net/8ab2d3287af0cefa2cc539e40600621d.png","retail_price":899},{"id":1010000,"name":"澳洲纯羊毛盖毯 加厚款","list_pic_url":"http://yanxuan.nosdn.127.net/3bec70b85337c3eec182e54380ef7370.png","retail_price":399},{"id":1010001,"name":"澳洲纯羊毛盖毯 舒适款","list_pic_url":"http://yanxuan.nosdn.127.net/a8b0a5def7d64e411dd98bdfb1fc989b.png","retail_price":299},{"id":1021004,"name":"澳洲羊羔毛AB面盖毯","list_pic_url":"http://yanxuan.nosdn.127.net/654b02045fde802b51d5bbf09a8b75f2.png","retail_price":299},{"id":1021010,"name":"色织水洗棉纯色四件套","list_pic_url":"http://yanxuan.nosdn.127.net/25d734cc0b2eae8f63f9deb1e4ad5f64.png","retail_price":299},{"id":1022000,"name":"意式毛线绣球四件套","list_pic_url":"http://yanxuan.nosdn.127.net/5350e35e6f22165f38928f3c2c52ac57.png","retail_price":299},{"id":1022001,"name":"法式浪漫绣球四件套","list_pic_url":"http://yanxuan.nosdn.127.net/bf8faee3b27b480f63b70056597b626d.png","retail_price":349},{"id":1023032,"name":"纯棉色织缎纹四件套","list_pic_url":"http://yanxuan.nosdn.127.net/e0b928ada728c140f6965bb41f47407b.png","retail_price":449}]}
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
        private List<GoodsListBean> goodsList;

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * id : 1006002
             * name : 轻奢纯棉刺绣水洗四件套
             * list_pic_url : http://yanxuan.nosdn.127.net/8ab2d3287af0cefa2cc539e40600621d.png
             * retail_price : 899
             */

            private int id;
            private String name;
            private String list_pic_url;
            private int retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public int getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}
