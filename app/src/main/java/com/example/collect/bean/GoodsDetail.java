package com.example.collect.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class GoodsDetail {

    public static class ResultBean implements MultiItemEntity {
        public final static int  TYPE_BANNER=0;//顶部Banner+价格+名称
        public final static int  TYPE_ATTRBUTE=1;//顶部Banner+价格+名称
        public final static int  TYPE_HTML=2;//h5页面
        public final static int  TYPE_TITLE=3;//标题
        public final static int  TYPE_ISSUE=4;//常见问题
        public final static int  TYPE_GOODSLIST=5;//关联商品列表
        public Object data;
        public int  itemtype;
        @Override
        public int getItemType() {
            return itemtype;
        }
    }

    /**
     * errno : 0
     * errmsg :
     * data : {"info":{"id":1155000,"category_id":1008009,"goods_sn":"1155000","name":"清新趣粉全棉四件套 条纹绿格","brand_id":0,"goods_number":100,"keywords":"","goods_brief":"清新趣粉全棉四件套 青粉拼接","goods_desc":"<p><img src=\"http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg\" _src=\"http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg\" _src=\"http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg\" _src=\"http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg\" _src=\"http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg\" _src=\"http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg\" _src=\"http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg\" _src=\"http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg\" _src=\"http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg\" _src=\"http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg\" _src=\"http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg\" _src=\"http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg\" _src=\"http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg\" _src=\"http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg\" _src=\"http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg\" _src=\"http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg\" _src=\"http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg\" _src=\"http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg\" _src=\"http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg\" _src=\"http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg\" _src=\"http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg\" _src=\"http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg\" _src=\"http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg\" _src=\"http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg\" _src=\"http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg\" _src=\"http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg\" _src=\"http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg\" _src=\"http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg\" _src=\"http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg\" _src=\"http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg\" _src=\"http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg\" _src=\"http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg\" _src=\"http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg\" _src=\"http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg\" _src=\"http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg\" _src=\"http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg\" _src=\"http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg\" _src=\"http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg\" _src=\"http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg\" _src=\"http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg\" _src=\"http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg\" _src=\"http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg\" _src=\"http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg\" _src=\"http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg\" _src=\"http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg\" _src=\"http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg\" _src=\"http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg\" _src=\"http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg\" _src=\"http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg\" _src=\"http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg\" _src=\"http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg\" _src=\"http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg\" _src=\"http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg\" _src=\"http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg\" _src=\"http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg\" style=\"\"/><\/p><p><br/><\/p>","is_on_sale":1,"add_time":0,"sort_order":12,"is_delete":0,"attribute_category":0,"counter_price":0,"extra_price":0,"is_new":0,"goods_unit":"件","primary_pic_url":"http://yanxuan.nosdn.127.net/7335f6e807e8507994710bca848de2d8.jpg","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399,"sell_volume":395,"primary_product_id":1162001,"unit_price":0,"promotion_desc":"限时购","promotion_tag":"","app_exclusive_price":0,"is_app_exclusive":0,"is_limited":0,"is_hot":0},"gallery":[{"id":673,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/517914d4f7d872b17a55e9c3864df717.jpg","img_desc":"","sort_order":5},{"id":674,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/6bdf224d6c0276a2737d6af775b6ed8a.jpg","img_desc":"","sort_order":5},{"id":675,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/6fa8774f6da6cc473ba3714aec95f6b6.jpg","img_desc":"","sort_order":5},{"id":676,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/2eca5d0f8a1ce61baf32311264cebdd1.jpg","img_desc":"","sort_order":5}],"attribute":[{"value":"100% 棉","name":"材质"},{"value":"1.5米床品： 被套 200*230cm/ 枕套：48*74cm*2/ 床单：245*250cm\n1.8米床品：被套 220*240cm/ 枕套：48*74cm*2/ 床单：245*270cm","name":"尺寸"},{"value":"条纹绿格","name":"颜色"},{"value":"GB/T 22844-2009","name":"执行标准"},{"value":"中国山东","name":"产地"}],"userHasCollect":0,"issue":[{"id":1,"goods_id":"1127052","question":"购买运费如何收取？","answer":"单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。\n(港澳台地区需满"},{"id":2,"goods_id":"1127052","question":"使用什么快递发货？","answer":"严选默认使用顺丰快递发货（个别商品使用其他快递），配送范围覆盖全国大部分地区（港澳台地区除"},{"id":3,"goods_id":"1127052","question":"如何申请退货？","answer":"1.自收到商品之日起30日内，顾客可申请无忧退货，退款将原路返还，不同的银行处理时间不同，"},{"id":4,"goods_id":"1127052","question":"如何开具发票？","answer":"1.如需开具普通发票，请在下单时选择\u201c我要开发票\u201d并填写相关信息（APP仅限2.4.0及以"}],"comment":{"count":0,"data":{}},"brand":{},"specificationList":[],"productList":[{"id":241,"goods_id":1155000,"goods_specification_ids":"","goods_sn":"1155000","goods_number":100,"retail_price":399}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * info : {"id":1155000,"category_id":1008009,"goods_sn":"1155000","name":"清新趣粉全棉四件套 条纹绿格","brand_id":0,"goods_number":100,"keywords":"","goods_brief":"清新趣粉全棉四件套 青粉拼接","goods_desc":"<p><img src=\"http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg\" _src=\"http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg\" _src=\"http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg\" _src=\"http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg\" _src=\"http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg\" _src=\"http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg\" _src=\"http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg\" _src=\"http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg\" _src=\"http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg\" _src=\"http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg\" _src=\"http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg\" _src=\"http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg\" _src=\"http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg\" _src=\"http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg\" _src=\"http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg\" _src=\"http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg\" _src=\"http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg\" _src=\"http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg\" _src=\"http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg\" _src=\"http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg\" _src=\"http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg\" _src=\"http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg\" _src=\"http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg\" _src=\"http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg\" _src=\"http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg\" _src=\"http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg\" _src=\"http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg\" _src=\"http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg\" _src=\"http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg\" _src=\"http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg\" _src=\"http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg\" _src=\"http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg\" _src=\"http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg\" _src=\"http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg\" _src=\"http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg\" _src=\"http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg\" _src=\"http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg\" _src=\"http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg\" _src=\"http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg\" _src=\"http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg\" _src=\"http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg\" _src=\"http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg\" _src=\"http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg\" _src=\"http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg\" _src=\"http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg\" _src=\"http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg\" _src=\"http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg\" _src=\"http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg\" _src=\"http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg\" _src=\"http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg\" _src=\"http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg\" _src=\"http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg\" _src=\"http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg\" _src=\"http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg\" style=\"\"/><\/p><p><img src=\"http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg\" _src=\"http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg\" style=\"\"/><\/p><p><br/><\/p>","is_on_sale":1,"add_time":0,"sort_order":12,"is_delete":0,"attribute_category":0,"counter_price":0,"extra_price":0,"is_new":0,"goods_unit":"件","primary_pic_url":"http://yanxuan.nosdn.127.net/7335f6e807e8507994710bca848de2d8.jpg","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399,"sell_volume":395,"primary_product_id":1162001,"unit_price":0,"promotion_desc":"限时购","promotion_tag":"","app_exclusive_price":0,"is_app_exclusive":0,"is_limited":0,"is_hot":0}
         * gallery : [{"id":673,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/517914d4f7d872b17a55e9c3864df717.jpg","img_desc":"","sort_order":5},{"id":674,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/6bdf224d6c0276a2737d6af775b6ed8a.jpg","img_desc":"","sort_order":5},{"id":675,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/6fa8774f6da6cc473ba3714aec95f6b6.jpg","img_desc":"","sort_order":5},{"id":676,"goods_id":1155000,"img_url":"http://yanxuan.nosdn.127.net/2eca5d0f8a1ce61baf32311264cebdd1.jpg","img_desc":"","sort_order":5}]
         * attribute : [{"value":"100% 棉","name":"材质"},{"value":"1.5米床品： 被套 200*230cm/ 枕套：48*74cm*2/ 床单：245*250cm\n1.8米床品：被套 220*240cm/ 枕套：48*74cm*2/ 床单：245*270cm","name":"尺寸"},{"value":"条纹绿格","name":"颜色"},{"value":"GB/T 22844-2009","name":"执行标准"},{"value":"中国山东","name":"产地"}]
         * userHasCollect : 0
         * issue : [{"id":1,"goods_id":"1127052","question":"购买运费如何收取？","answer":"单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。\n(港澳台地区需满"},{"id":2,"goods_id":"1127052","question":"使用什么快递发货？","answer":"严选默认使用顺丰快递发货（个别商品使用其他快递），配送范围覆盖全国大部分地区（港澳台地区除"},{"id":3,"goods_id":"1127052","question":"如何申请退货？","answer":"1.自收到商品之日起30日内，顾客可申请无忧退货，退款将原路返还，不同的银行处理时间不同，"},{"id":4,"goods_id":"1127052","question":"如何开具发票？","answer":"1.如需开具普通发票，请在下单时选择\u201c我要开发票\u201d并填写相关信息（APP仅限2.4.0及以"}]
         * comment : {"count":0,"data":{}}
         * brand : {}
         * specificationList : []
         * productList : [{"id":241,"goods_id":1155000,"goods_specification_ids":"","goods_sn":"1155000","goods_number":100,"retail_price":399}]
         */

        private InfoBean info;
        private int userHasCollect;
        private CommentBean comment;
        private BrandBean brand;
        private List<GalleryBean> gallery;
        private List<AttributeBean> attribute;
        private List<IssueBean> issue;
        private List<?> specificationList;
        private List<ProductListBean> productList;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public int getUserHasCollect() {
            return userHasCollect;
        }

        public void setUserHasCollect(int userHasCollect) {
            this.userHasCollect = userHasCollect;
        }

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public BrandBean getBrand() {
            return brand;
        }

        public void setBrand(BrandBean brand) {
            this.brand = brand;
        }

        public List<GalleryBean> getGallery() {
            return gallery;
        }

        public void setGallery(List<GalleryBean> gallery) {
            this.gallery = gallery;
        }

        public List<AttributeBean> getAttribute() {
            return attribute;
        }

        public void setAttribute(List<AttributeBean> attribute) {
            this.attribute = attribute;
        }

        public List<IssueBean> getIssue() {
            return issue;
        }

        public void setIssue(List<IssueBean> issue) {
            this.issue = issue;
        }

        public List<?> getSpecificationList() {
            return specificationList;
        }

        public void setSpecificationList(List<?> specificationList) {
            this.specificationList = specificationList;
        }

        public List<ProductListBean> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListBean> productList) {
            this.productList = productList;
        }

        public static class InfoBean {
            /**
             * id : 1155000
             * category_id : 1008009
             * goods_sn : 1155000
             * name : 清新趣粉全棉四件套 条纹绿格
             * brand_id : 0
             * goods_number : 100
             * keywords :
             * goods_brief : 清新趣粉全棉四件套 青粉拼接
             * goods_desc : <p><img src="http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg" _src="http://yanxuan.nosdn.127.net/162f14bce2afba3a484ce8fb5da1e58b.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg" _src="http://yanxuan.nosdn.127.net/1f7942650759087591c5983b8833b0b0.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg" _src="http://yanxuan.nosdn.127.net/7b2c61359c3323f426a0214d79f52e5d.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg" _src="http://yanxuan.nosdn.127.net/4ef5a035b31b1dea51c0f9ad89df9af3.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg" _src="http://yanxuan.nosdn.127.net/e78cd4ddd9bd39ab9a488fef9b5f7b3a.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg" _src="http://yanxuan.nosdn.127.net/6cce2f34025ab487af8707ee4cf61373.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg" _src="http://yanxuan.nosdn.127.net/248de06b79ddf1bc6e28a00ffbbb97d0.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg" _src="http://yanxuan.nosdn.127.net/c2306432efd11b36979518c91f3dac76.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg" _src="http://yanxuan.nosdn.127.net/d62be6560ff53b1fd6b8f83664965758.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg" _src="http://yanxuan.nosdn.127.net/879123cb7355ce5aa2df371bf8821754.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg" _src="http://yanxuan.nosdn.127.net/24bd066e91fe31da4c21fb6f13d0b944.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg" _src="http://yanxuan.nosdn.127.net/9da18ea054a561a17c36e41d693bfdae.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg" _src="http://yanxuan.nosdn.127.net/71873676e788a2d2aa5184f46cc0f30e.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg" _src="http://yanxuan.nosdn.127.net/b3f9463598c55d2c55428b2eef8bf556.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg" _src="http://yanxuan.nosdn.127.net/d1321c2db83e7485c67265427fa986bc.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg" _src="http://yanxuan.nosdn.127.net/4cc8bc6028a45eddab15e21ebc7caef7.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg" _src="http://yanxuan.nosdn.127.net/27453a8037edc367424e6432a3e5a59c.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg" _src="http://yanxuan.nosdn.127.net/528ef8f963f9733d8cfd0f50556ae110.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg" _src="http://yanxuan.nosdn.127.net/cb3c92fed21740cc6b5c5dc16fc60508.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg" _src="http://yanxuan.nosdn.127.net/0dee0fd961eaffd7aa2bdaf62d2ab126.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg" _src="http://yanxuan.nosdn.127.net/661e1cb14a801d03f28626196c00d14f.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg" _src="http://yanxuan.nosdn.127.net/2b6a2f6a7f3a45039b0b7c572c2eeed8.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg" _src="http://yanxuan.nosdn.127.net/e46db149caf4b825f4a90627e0db6a79.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg" _src="http://yanxuan.nosdn.127.net/98673c4ff33fc8c55bf88945dbef364c.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg" _src="http://yanxuan.nosdn.127.net/9a2324cb4ff8f4332c51343efeaafe8e.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg" _src="http://yanxuan.nosdn.127.net/eb0d21207bf5b26592511ef80e48eb91.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg" _src="http://yanxuan.nosdn.127.net/be386763462ada086662387e40431c85.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg" _src="http://yanxuan.nosdn.127.net/71724c37bc98358af22d25a4edebe12d.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg" _src="http://yanxuan.nosdn.127.net/3226eb33802d18a6baa093b1ccc3f412.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg" _src="http://yanxuan.nosdn.127.net/32370f76a781924f6e0252abdea047f6.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg" _src="http://yanxuan.nosdn.127.net/22c82828b81e11053849f3c9f826f453.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg" _src="http://yanxuan.nosdn.127.net/e8c42123ac126046542176d511a29139.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg" _src="http://yanxuan.nosdn.127.net/d981ab4821ca98c89e71d2a2a9b23330.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg" _src="http://yanxuan.nosdn.127.net/995a72c9c8bb895f5445a473daccc218.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg" _src="http://yanxuan.nosdn.127.net/251151c89c54c9c272288ed461533a8c.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg" _src="http://yanxuan.nosdn.127.net/bba4921b09f7c9eb4bae76259d7d82e2.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg" _src="http://yanxuan.nosdn.127.net/0fd159ef30bfd4cb6e4c37141ad96666.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg" _src="http://yanxuan.nosdn.127.net/4e31861a89e1e10be81f5290e31e6b85.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg" _src="http://yanxuan.nosdn.127.net/3404e5c9b9e9e3855a52831a1d4acad7.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg" _src="http://yanxuan.nosdn.127.net/5d15b51fc382847b8de4a4b6fad3646b.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg" _src="http://yanxuan.nosdn.127.net/6fd940b500b07c5157a7db17d858c56f.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg" _src="http://yanxuan.nosdn.127.net/4cf02bfda7429cb78da05f8b521e5195.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg" _src="http://yanxuan.nosdn.127.net/74ed4ea956e43e6b1f37b1dd31c6feee.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg" _src="http://yanxuan.nosdn.127.net/77d288d7c8e815e014f6ceac652adf83.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg" _src="http://yanxuan.nosdn.127.net/18478afad61f4fad519a4fe598c38bb8.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg" _src="http://yanxuan.nosdn.127.net/f527072aeaed7abb974551d7ad93faf4.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg" _src="http://yanxuan.nosdn.127.net/276d97cc862f718bfb7cd8a5970d2b9a.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg" _src="http://yanxuan.nosdn.127.net/1765a6390fd9116320230cea1b2e2570.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg" _src="http://yanxuan.nosdn.127.net/ee6eff91b9e9ee9c8a70cf9ad59cd274.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg" _src="http://yanxuan.nosdn.127.net/4db4a90e1e83e2e77b4b17deb6b618c4.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg" _src="http://yanxuan.nosdn.127.net/3e58b2129b6ca7f8f845d88ccb1ecda6.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg" _src="http://yanxuan.nosdn.127.net/fe901e2f92e213b444f4950a6adb320f.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg" _src="http://yanxuan.nosdn.127.net/11c552fba5a1ba0bf6189da2d243db7d.jpg" style=""/></p><p><img src="http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg" _src="http://yanxuan.nosdn.127.net/4c78602cdbba3992711257325de376ed.jpg" style=""/></p><p><br/></p>
             * is_on_sale : 1
             * add_time : 0
             * sort_order : 12
             * is_delete : 0
             * attribute_category : 0
             * counter_price : 0
             * extra_price : 0
             * is_new : 0
             * goods_unit : 件
             * primary_pic_url : http://yanxuan.nosdn.127.net/7335f6e807e8507994710bca848de2d8.jpg
             * list_pic_url : http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png
             * retail_price : 399
             * sell_volume : 395
             * primary_product_id : 1162001
             * unit_price : 0
             * promotion_desc : 限时购
             * promotion_tag :
             * app_exclusive_price : 0
             * is_app_exclusive : 0
             * is_limited : 0
             * is_hot : 0
             */

            private int id;
            private int category_id;
            private String goods_sn;
            private String name;
            private int brand_id;
            private int goods_number;
            private String keywords;
            private String goods_brief;
            private String goods_desc;
            private int is_on_sale;
            private int add_time;
            private int sort_order;
            private int is_delete;
            private int attribute_category;
            private int counter_price;
            private int extra_price;
            private int is_new;
            private String goods_unit;
            private String primary_pic_url;
            private String list_pic_url;
            private int retail_price;
            private int sell_volume;
            private int primary_product_id;
            private int unit_price;
            private String promotion_desc;
            private String promotion_tag;
            private int app_exclusive_price;
            private int is_app_exclusive;
            private int is_limited;
            private int is_hot;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getGoods_brief() {
                return goods_brief;
            }

            public void setGoods_brief(String goods_brief) {
                this.goods_brief = goods_brief;
            }

            public String getGoods_desc() {
                return goods_desc;
            }

            public void setGoods_desc(String goods_desc) {
                this.goods_desc = goods_desc;
            }

            public int getIs_on_sale() {
                return is_on_sale;
            }

            public void setIs_on_sale(int is_on_sale) {
                this.is_on_sale = is_on_sale;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public int getAttribute_category() {
                return attribute_category;
            }

            public void setAttribute_category(int attribute_category) {
                this.attribute_category = attribute_category;
            }

            public int getCounter_price() {
                return counter_price;
            }

            public void setCounter_price(int counter_price) {
                this.counter_price = counter_price;
            }

            public int getExtra_price() {
                return extra_price;
            }

            public void setExtra_price(int extra_price) {
                this.extra_price = extra_price;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public String getGoods_unit() {
                return goods_unit;
            }

            public void setGoods_unit(String goods_unit) {
                this.goods_unit = goods_unit;
            }

            public String getPrimary_pic_url() {
                return primary_pic_url;
            }

            public void setPrimary_pic_url(String primary_pic_url) {
                this.primary_pic_url = primary_pic_url;
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

            public int getSell_volume() {
                return sell_volume;
            }

            public void setSell_volume(int sell_volume) {
                this.sell_volume = sell_volume;
            }

            public int getPrimary_product_id() {
                return primary_product_id;
            }

            public void setPrimary_product_id(int primary_product_id) {
                this.primary_product_id = primary_product_id;
            }

            public int getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(int unit_price) {
                this.unit_price = unit_price;
            }

            public String getPromotion_desc() {
                return promotion_desc;
            }

            public void setPromotion_desc(String promotion_desc) {
                this.promotion_desc = promotion_desc;
            }

            public String getPromotion_tag() {
                return promotion_tag;
            }

            public void setPromotion_tag(String promotion_tag) {
                this.promotion_tag = promotion_tag;
            }

            public int getApp_exclusive_price() {
                return app_exclusive_price;
            }

            public void setApp_exclusive_price(int app_exclusive_price) {
                this.app_exclusive_price = app_exclusive_price;
            }

            public int getIs_app_exclusive() {
                return is_app_exclusive;
            }

            public void setIs_app_exclusive(int is_app_exclusive) {
                this.is_app_exclusive = is_app_exclusive;
            }

            public int getIs_limited() {
                return is_limited;
            }

            public void setIs_limited(int is_limited) {
                this.is_limited = is_limited;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }
        }

        public static class CommentBean {
            /**
             * count : 0
             * data : {}
             */

            private int count;
            private DataBean data;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
            }
        }

        public static class BrandBean {
        }

        public static class GalleryBean {
            /**
             * id : 673
             * goods_id : 1155000
             * img_url : http://yanxuan.nosdn.127.net/517914d4f7d872b17a55e9c3864df717.jpg
             * img_desc :
             * sort_order : 5
             */

            private int id;
            private int goods_id;
            private String img_url;
            private String img_desc;
            private int sort_order;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getImg_desc() {
                return img_desc;
            }

            public void setImg_desc(String img_desc) {
                this.img_desc = img_desc;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }
        }

        public static class AttributeBean {
            /**
             * value : 100% 棉
             * name : 材质
             */

            private String value;
            private String name;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class IssueBean {
            /**
             * id : 1
             * goods_id : 1127052
             * question : 购买运费如何收取？
             * answer : 单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。
             (港澳台地区需满
             */

            private int id;
            private String goods_id;
            private String question;
            private String answer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }
        }

        public static class ProductListBean {
            /**
             * id : 241
             * goods_id : 1155000
             * goods_specification_ids :
             * goods_sn : 1155000
             * goods_number : 100
             * retail_price : 399
             */

            private int id;
            private int goods_id;
            private String goods_specification_ids;
            private String goods_sn;
            private int goods_number;
            private int retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_specification_ids() {
                return goods_specification_ids;
            }

            public void setGoods_specification_ids(String goods_specification_ids) {
                this.goods_specification_ids = goods_specification_ids;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
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
