package com.example.collect.ui.mainpage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.collect.R;
import com.example.collect.bean.MainBean;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class MainPageRec_Adapter extends BaseMultiItemQuickAdapter<MainBean.ResultData, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MainPageRec_Adapter(List<MainBean.ResultData> data) {
        super(data);
        //banner
        addItemType(MainBean.ResultData.TYPE_BANNER, R.layout.main_banner);
        //TabLayout
        addItemType(MainBean.ResultData.TYPE_TAB, R.layout.main_tab);
        //标题
        addItemType(MainBean.ResultData.TYPE_TITLE, R.layout.main_title);
        //黑板
        addItemType(MainBean.ResultData.TYPE_BRAND, R.layout.main_beand);
        //新品首发
        addItemType(MainBean.ResultData.TYPE_NOW, R.layout.main_now);
        //人气推荐
        addItemType(MainBean.ResultData.TYPE_HOT, R.layout.main_hot);
        //专题精选
        addItemType(MainBean.ResultData.TYPE_ZHUANTI, R.layout.main_zhuang);
        //底部列表展示
        addItemType(MainBean.ResultData.TYPE_LIST, R.layout.main_now);

    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean.ResultData item) {
        switch (helper.getItemViewType()) {
            case MainBean.ResultData.TYPE_BANNER:
                banner(helper,item);
                break;
            case MainBean.ResultData.TYPE_TAB:
                tab(helper,item);
                break;
            case MainBean.ResultData.TYPE_TITLE:
                title(helper,item);
                break;
            case MainBean.ResultData.TYPE_BRAND:
                brand(helper,item);
                break;
            case MainBean.ResultData.TYPE_NOW:
                nowShop(helper,item);
                break;
            case MainBean.ResultData.TYPE_HOT:
                hotShop(helper,item);
                break;
            case MainBean.ResultData.TYPE_ZHUANTI:
                zhuanTi(helper,item);
                break;
            case MainBean.ResultData.TYPE_LIST:
                list(helper,item);
                break;
        }
    }

    private void list(BaseViewHolder helper, MainBean.ResultData item) {
        MainBean.DataBean.CategoryListBean.GoodsListBean data= (MainBean.DataBean.CategoryListBean.GoodsListBean) item.data;
        helper.setText(R.id.now_name,data.getName());
        helper.setText(R.id.now_price,"¥"+data.getRetail_price());
        Glide.with(mContext).load(data.getList_pic_url()).into((ImageView) helper.getView(R.id.now_image));
    }

    private void zhuanTi(BaseViewHolder helper, MainBean.ResultData item) {
        MainBean.DataBean.TopicListBean data= (MainBean.DataBean.TopicListBean) item.data;
        helper.setText(R.id.zhuang_name,data.getTitle());
        helper.setText(R.id.zhaung_price,"¥"+data.getPrice_info()+"元起");
        helper.setText(R.id.zhuang_desc,data.getSubtitle());
        Glide.with(mContext).load(data.getItem_pic_url()).into((ImageView) helper.getView(R.id.zhaung_image));
    }

    private void hotShop(BaseViewHolder helper, MainBean.ResultData item) {
        MainBean.DataBean.HotGoodsListBean data= (MainBean.DataBean.HotGoodsListBean) item.data;
        helper.setText(R.id.hot_name,data.getName());
        helper.setText(R.id.hot_desc,data.getGoods_brief());
        helper.setText(R.id.hot_price,"¥"+data.getRetail_price());
        Glide.with(mContext).load(data.getList_pic_url()).into((ImageView) helper.getView(R.id.hot_image));
    }

    private void nowShop(BaseViewHolder helper, MainBean.ResultData item) {
        MainBean.DataBean.NewGoodsListBean data= (MainBean.DataBean.NewGoodsListBean) item.data;
        helper.setText(R.id.now_name,data.getName());
        helper.setText(R.id.now_price,"¥"+data.getRetail_price());
        Glide.with(mContext).load(data.getList_pic_url()).into((ImageView) helper.getView(R.id.now_image));
    }

    private void brand(BaseViewHolder helper, MainBean.ResultData item) {
        MainBean.DataBean.BrandListBean data= (MainBean.DataBean.BrandListBean) item.data;
        ImageView image = helper.getView(R.id.brand_image);
        Glide.with(mContext).load(data.getNew_pic_url()).into(image);
        helper.setText(R.id.brand_name,data.getName());
        helper.setText(R.id.brand_price,"¥"+data.getFloor_price()+"元起");
    }

    private void title(BaseViewHolder helper, MainBean.ResultData item) {
        String name= (String) item.data;
        helper.setText(R.id.item_title,name);
    }

    private void tab(BaseViewHolder helper, MainBean.ResultData item) {
        TabLayout tab = helper.getView(R.id.item_tab);
        List<MainBean.DataBean.ChannelBean> data= (List<MainBean.DataBean.ChannelBean>) item.data;
        if(tab.getTabCount()<data.size()){
            for (int i = 0; i < data.size(); i++) {
                tab.addTab(tab.newTab().setText(data.get(i).getName()));
            }
        }

    }

    private void banner(BaseViewHolder helper, MainBean.ResultData item) {
        Banner banner = helper.getView(R.id.item_banner);
        List<MainBean.DataBean.BannerBean> data= (List<MainBean.DataBean.BannerBean>) item.data;
        banner.setImages(data).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                MainBean.DataBean.BannerBean item= (MainBean.DataBean.BannerBean) path;
                Glide.with(mContext).load(item.getImage_url()).into(imageView);
            }
        }).start();
    }
}
