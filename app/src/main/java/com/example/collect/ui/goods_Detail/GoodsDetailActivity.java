package com.example.collect.ui.goods_Detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.BaseApp;
import com.example.collect.base.Constants;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;
import com.example.collect.bean.GoodsResult;
import com.example.collect.presenter.GoodsDetailPresenter;
import com.example.collect.ui.login.LoginActivity;
import com.example.collect.util.SpUtil;
import com.example.collect.view.GoodsDetailView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import q.rorbin.badgeview.QBadgeView;

public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter> implements View.OnClickListener, GoodsDetailView {


    private int id;
    private RecyclerView mRecGoods;
    private ImageView mLike;
    private ImageView mBike;
    private TextView mJoin;
    private TextView mBuy;
    //private GridLayoutManager.SpanSizeLookup mananer;
    private GridLayoutManager layoutManager;
    private GoodsDetailAdapter adapter;
    private GoodsDetail mGoodsDetail;

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        intent.putExtra(Constants.ID, id);
        context.startActivity(intent);
    }


    @Override
    protected GoodsDetailPresenter initPresenter() {
        return new GoodsDetailPresenter();
    }

    @Override
    public void initView() {
        id = getIntent().getIntExtra(Constants.ID, 0);
        mRecGoods = (RecyclerView) findViewById(R.id.goods_rec);
        mLike = (ImageView) findViewById(R.id.like);
        mLike.setOnClickListener(this);
        mBike = (ImageView) findViewById(R.id.bike);
        mBike.setOnClickListener(this);
        mJoin = (TextView) findViewById(R.id.join);
        mJoin.setOnClickListener(this);
        mBuy = (TextView) findViewById(R.id.buy);
        mBuy.setOnClickListener(this);

        ArrayList<GoodsDetail.ResultBean> data = new ArrayList<>();
        adapter = new GoodsDetailAdapter(data);
        mRecGoods.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData(id);
        if (BaseApp.isLogin){
            mPresenter.getCartData();
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_goods_detail;
    }
    private void createManager(final int size) {
        layoutManager = new GridLayoutManager(this,2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                if(i>=size){
                    return 1;
                }else {
                    return 2;
                }
            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like:
                // TODO 20/03/27
                break;
            case R.id.bike:
                // TODO 20/03/27
                break;
            case R.id.join:
                // TODO 20/03/27
                addCart();
                break;
            case R.id.buy:
                // TODO 20/03/27
                break;
            default:
                break;
        }
    }

    private void addCart() {
        //添加购物车之前，判断是否登录，如果
        if (BaseApp.isLogin){
            if (mGoodsDetail!=null){
                GoodsDetail.DataBeanX.ProductListBean bean = mGoodsDetail.getData().getProductList().get(0);
                mPresenter.addCart(bean.getGoods_id(),1,bean.getId());
            }else {
                startActivity(new Intent(this, LoginActivity.class));
            }

        }
    }

    @Override
    public void setData(GoodsDetail goodsDetail) {
        this.mGoodsDetail=goodsDetail;

        ArrayList<GoodsDetail.ResultBean> resultBeans=new ArrayList<>();
        //Banner轮播图 第一个条目
        GoodsDetail.ResultBean top = new GoodsDetail.ResultBean();
        top.itemtype=GoodsDetail.ResultBean.TYPE_BANNER;
        top.data=goodsDetail.getData();
        resultBeans.add(top);

        //标题商品参数
        GoodsDetail.ResultBean attribute = new GoodsDetail.ResultBean();
        attribute.itemtype=GoodsDetail.ResultBean.TYPE_TITLE;
        attribute.data="商品参数";
        resultBeans.add(attribute);
        //参数列表
        for (int i = 0; i < goodsDetail.getData().getAttribute().size(); i++) {
            GoodsDetail.ResultBean attr = new GoodsDetail.ResultBean();
            attr.itemtype=GoodsDetail.ResultBean.TYPE_ATTRBUTE;
            attr.data=goodsDetail.getData().getAttribute().get(i);
            resultBeans.add(attr);
        }

        //h5页面
        GoodsDetail.ResultBean html = new GoodsDetail.ResultBean();
        html.itemtype= GoodsDetail.ResultBean.TYPE_HTML;
        html.data=goodsDetail.getData().getInfo().getGoods_desc();
        resultBeans.add(html);
        //标题
        GoodsDetail.ResultBean issueTitle = new GoodsDetail.ResultBean();
        issueTitle.itemtype=GoodsDetail.ResultBean.TYPE_TITLE;
        issueTitle.data="-- 常见问题 --";
        resultBeans.add(issueTitle);
        //常见问题数据
        for (int i = 0; i < goodsDetail.getData().getIssue().size(); i++) {
            GoodsDetail.ResultBean issue = new GoodsDetail.ResultBean();
            issue.itemtype=GoodsDetail.ResultBean.TYPE_ISSUE;
            issue.data=goodsDetail.getData().getIssue().get(i);
            resultBeans.add(issue);
        }
        //标题
        GoodsDetail.ResultBean see = new GoodsDetail.ResultBean();
        see.itemtype=GoodsDetail.ResultBean.TYPE_TITLE;
        see.data="-- 大家都在看 --";
        resultBeans.add(see);
        //关联商品列表
        int goods_id = goodsDetail.getData().getProductList().get(0).getGoods_id();
        createManager(resultBeans.size());
        mRecGoods.setLayoutManager(layoutManager);
        mPresenter.getDataRelate(goods_id);
        adapter.addData(resultBeans);
    }

    @Override
    public void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataRelate(GoodsDetailRelate goodsDetailRelate) {
        ArrayList<GoodsDetail.ResultBean> resultBeans = new ArrayList<>();
        for (int i = 0; i <goodsDetailRelate.getData().getGoodsList().size() ; i++) {
            GoodsDetail.ResultBean resultBean = new GoodsDetail.ResultBean();
            resultBean.itemtype=GoodsDetail.ResultBean.TYPE_GOODSLIST;
            resultBean.data=goodsDetailRelate.getData().getGoodsList().get(i);
            resultBeans.add(resultBean);
        }
        adapter.addData(resultBeans);
    }

    @Override
    public void setAddCart(AddCart addCart) {
        showToast("添加成功");
        //添加红色的气泡，显示购物车商品数量
        addBadge(addCart.getData().getCartTotal().getGoodsCount());
    }

    @Override
    public void setCartData(AddCart addCart) {
        addBadge(addCart.getData().getCartTotal().getGoodsCount());
    }

    private void addBadge(int goodsCount) {
        new QBadgeView(this).bindTarget(mBike).setBadgeNumber(goodsCount);
    }
}
