package com.example.collect.ui.mainpage;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collect.R;
import com.example.collect.base.BaseFragment;
import com.example.collect.bean.MainBean;
import com.example.collect.presenter.MainPagePresenter;
import com.example.collect.ui.search.SearchActivity;
import com.example.collect.view.MainPageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainPageFragment extends BaseFragment<MainPagePresenter> implements MainPageView {

    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.tv)
    TextView mTv;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<MainBean.ResultData> dataBeans;
    private MainPageRec_Adapter adapter;

    public static MainPageFragment newInstance() {
        MainPageFragment fragment = new MainPageFragment();
        return fragment;
    }

    @Override
    protected MainPagePresenter initPresenter() {
        return new MainPagePresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initView(View view) {
        gridLayoutManager = new GridLayoutManager(getContext(), 6);
        dataBeans = new ArrayList<>();
        adapter = new MainPageRec_Adapter(dataBeans);
        mRec.setAdapter(adapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page;
    }

    @Override
    public void setData(MainBean mainBean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<MainBean.ResultData> beans = new ArrayList<>();
                MainBean.DataBean data = mainBean.getData();
                //第一个Banner
                List<MainBean.DataBean.BannerBean> banners = data.getBanner();
                MainBean.ResultData banner = new MainBean.ResultData();
                banner.type = MainBean.ResultData.TYPE_BANNER;
                banner.data = banners;
                beans.add(banner);
                //第二个TabLayout
                List<MainBean.DataBean.ChannelBean> categoryList = data.getChannel();
                MainBean.ResultData tab = new MainBean.ResultData();
                tab.type = MainBean.ResultData.TYPE_TAB;
                tab.data = categoryList;
                beans.add(tab);
                //第三个品牌 标题:品牌制造商直供
                MainBean.ResultData title_make = new MainBean.ResultData();
                title_make.type = MainBean.ResultData.TYPE_TITLE;
                title_make.data = "品牌制造商直供";
                beans.add(title_make);
                //第四个 黑板
                List<MainBean.DataBean.BrandListBean> brandList = data.getBrandList();
                for (int i = 0; i < brandList.size(); i++) {
                    MainBean.DataBean.BrandListBean brandListBean = brandList.get(i);
                    MainBean.ResultData brand = new MainBean.ResultData();
                    brand.type = MainBean.ResultData.TYPE_BRAND;
                    brand.data = brandListBean;
                    beans.add(brand);
                }
                //第五个 标题:周一周四 新品首发
                MainBean.ResultData title_now = new MainBean.ResultData();
                title_now.type = MainBean.ResultData.TYPE_TITLE;
                title_now.data = "周一周四 新品首发";
                beans.add(title_now);
                //第六个 新品商品条目
                List<MainBean.DataBean.NewGoodsListBean> newGoodsList = data.getNewGoodsList();
                for (int i = 0; i < newGoodsList.size(); i++) {
                    MainBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsList.get(i);
                    MainBean.ResultData newShop = new MainBean.ResultData();
                    newShop.type = MainBean.ResultData.TYPE_NOW;
                    newShop.data = newGoodsListBean;
                    beans.add(newShop);
                }
                //第七个 标题:人气推荐
                MainBean.ResultData title_hot = new MainBean.ResultData();
                title_hot.type = MainBean.ResultData.TYPE_TITLE;
                title_hot.data = "人气推荐";
                beans.add(title_hot);
                //第八个 人气商品
                List<MainBean.DataBean.HotGoodsListBean> hotGoodsList = data.getHotGoodsList();
                for (int i = 0; i < hotGoodsList.size(); i++) {
                    MainBean.DataBean.HotGoodsListBean hotGoodsListBean = hotGoodsList.get(i);
                    MainBean.ResultData hotShop = new MainBean.ResultData();
                    hotShop.type = MainBean.ResultData.TYPE_HOT;
                    hotShop.data = hotGoodsListBean;
                    beans.add(hotShop);
                }
                //第九个 标题:专题精选
                MainBean.ResultData title_zhaung = new MainBean.ResultData();
                title_zhaung.type = MainBean.ResultData.TYPE_TITLE;
                title_zhaung.data = "专题精选";
                beans.add(title_zhaung);
                //第十个 精选商品
                List<MainBean.DataBean.TopicListBean> topicList = data.getTopicList();
                for (int i = 0; i < topicList.size(); i++) {
                    MainBean.DataBean.TopicListBean topicListBean = topicList.get(i);
                    MainBean.ResultData jing = new MainBean.ResultData();
                    jing.type = MainBean.ResultData.TYPE_ZHUANTI;
                    jing.data = topicListBean;
                    beans.add(jing);
                }
                //第十一个 居家产品展示
                List<MainBean.DataBean.CategoryListBean> categoryList1 = data.getCategoryList();
                for (int i = 0; i < categoryList1.size(); i++) {
                    MainBean.DataBean.CategoryListBean categoryListBean = categoryList1.get(i);
                    //标题
                    MainBean.ResultData title_channel = new MainBean.ResultData();
                    title_channel.type = MainBean.ResultData.TYPE_TITLE;
                    title_channel.data = categoryListBean.getName();
                    beans.add(title_channel);
                    List<MainBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
                    for (int j = 0; j < goodsList.size(); j++) {
                        MainBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsList.get(j);
                        MainBean.ResultData xin = new MainBean.ResultData();
                        xin.type = MainBean.ResultData.TYPE_LIST;
                        xin.data = goodsListBean;
                        beans.add(xin);
                    }
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dataBeans.addAll(beans);
                        adapter.addData(dataBeans);
                    }
                });


            }
        }).start();
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                MainBean.ResultData resultData = dataBeans.get(i);
                switch (resultData.type) {
                    case MainBean.ResultData.TYPE_BANNER:
                    case MainBean.ResultData.TYPE_TAB:
                    case MainBean.ResultData.TYPE_TITLE:
                    case MainBean.ResultData.TYPE_HOT:
                        return 6;
                    case MainBean.ResultData.TYPE_ZHUANTI:
                        return 2;
                    case MainBean.ResultData.TYPE_BRAND:
                    case MainBean.ResultData.TYPE_LIST:
                    case MainBean.ResultData.TYPE_NOW:
                        return 3;
                }
                return 0;
            }
        });
        mRec.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void show(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tv})
    public void onViewClicked() {
        go2Search();
    }

    private void go2Search() {
        startActivity(new Intent(getContext(), SearchActivity.class));
    }
}
