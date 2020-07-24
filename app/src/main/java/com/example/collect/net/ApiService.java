package com.example.collect.net;

import com.example.collect.bean.AddCart;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;
import com.example.collect.bean.GoodsResult;
import com.example.collect.bean.LoginBean;
import com.example.collect.bean.MainBean;
import com.example.collect.bean.RegisterBean;
import com.example.collect.bean.SortItemBean;
import com.example.collect.bean.SortTabBean;
import com.example.collect.bean.TopicBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    String BASE_URL="https://cdwan.cn/api/";

    //首页数据
    @GET("index")
    Flowable<MainBean> getData();

    @GET("topic/list")
    Observable<TopicBean> getTopic2(@Query("page") int page,
                                    @Query("size") int size);

    //flowable也是rxjava的被观察者,使用起来和Observable一样的,但是它支持背压模式
    @GET("topic/list")
    Flowable<TopicBean> getTopic(@Query("page") int page,
                                 @Query("size") int size);


    //分类竖着导航
    @GET("catalog/index")
    Flowable<SortTabBean> getSortTab();

    /**
     * 分类右边对应的当前分类的数据
     * @return
     */
    @GET("catalog/current")
    Flowable<SortItemBean> getSortItem(@Query("id") int id);

    //商品详情列表数据
    @GET("goods/list")
    Flowable<GoodsResult> getGoods(@Query("categoryId") int id, @Query("page") int page, @Query("size") int size);

    //商品购买详情页
    @GET("goods/detail")
    Flowable<GoodsDetail> getGoodsDetail(@Query("id") int id);
    //商品购买详情页
    @GET("goods/related")
    Flowable<GoodsDetailRelate> getGoodsReleate(@Query("id") int id);

    @POST("auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("nickname") String nickname, @Field("password") String password);


    // @Headers
    @Headers("Client-Type: ANDROID")
    @POST("auth/register")
    @FormUrlEncoded
    Flowable<RegisterBean> register(@Field("nickname") String nickname, @Field("password") String password);

    /**
     * 获取购物车数据
     */
    @GET("cart/index")
    Flowable<AddCart> getCartData();


    /**
     * 获取购物车数据
     */
    /**
     * 获取购物车数据
     * @return
     */
    @POST("cart/update")
    @FormUrlEncoded
    Flowable<AddCart> updateGoodsNumber(@Field("productId") int productId,
                                        @Field("goodsId") int goodsId,
                                        @Field("number") int number,
                                        @Field("id") long id);

    /**
     * 加入购物车
     * @param goodsId
     * @param number
     * @param productId
     * @return
     */
    @POST("cart/add")
    @FormUrlEncoded
    Flowable<AddCart> addCart2(@Field("goodsId") int goodsId,
                               @Field("number") int number,
                               @Field("productId") int productId);

    /**
     * 删除购物车商品
     * 多个商品删除，id用逗号隔开
     * @return
     */
    @POST("cart/delete")
    @FormUrlEncoded
    Flowable<AddCart> deleteGoods(@Field("productIds") String productIds);
}
