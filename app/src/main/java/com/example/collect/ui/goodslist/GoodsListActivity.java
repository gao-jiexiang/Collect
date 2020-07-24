package com.example.collect.ui.goodslist;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.Constants;
import com.example.collect.bean.GoodsResult;
import com.example.collect.bean.SortItemBean;
import com.example.collect.presenter.GoodsListPresenter;
import com.example.collect.ui.goods_Detail.GoodsDetailActivity;
import com.example.collect.view.GoodsListView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class GoodsListActivity extends BaseActivity<GoodsListPresenter> implements GoodsListView {

    private TabLayout mTabGoods;
    private RecyclerView mResGoods;
    private int posi;
    private ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean> data;
    private int id;
    private GoodsAdapter adapter;
    private String name;
    private int position;
    private ArrayList<String> tabs;
    private int new_posi;
    private ArrayList<Integer> integers;
    private List<GoodsResult.DataBeanX.DataBean> data1;
    private ArrayList<GoodsResult.DataBeanX.DataBean> dataBeans;
    private View inflate;


    @Override
    protected int getLayout() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected GoodsListPresenter initPresenter() {
        return new GoodsListPresenter();
    }

    @Override
    public void initView() {
        mTabGoods = (TabLayout) findViewById(R.id.tabLayout);
        mResGoods = (RecyclerView) findViewById(R.id.rlv);
        mResGoods.setLayoutManager(new GridLayoutManager(this,2));
        dataBeans = new ArrayList<>();
        adapter = new GoodsAdapter(R.layout.fragment_goodsadapter, dataBeans);
        mResGoods.setAdapter(adapter);
        addHead();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int id = data1.get(position).getId();
                GoodsDetailActivity.start(GoodsListActivity.this,id);
            }
        });
    }



    @Override
    public void initData() {
        posi = getIntent().getIntExtra(Constants.POSITION, 0);
        id = getIntent().getIntExtra(Constants.ID, 0);
        name = getIntent().getStringExtra(Constants.USERNAME);
        new_posi = posi;
        data = (ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean>) getIntent().getSerializableExtra(Constants.DATA);
        initTab();
        initTabId();
        position=posi;
        for (int i = 0; i < data.size(); i++) {
            String name2 = data.get(i).getName();
            mTabGoods.addTab(mTabGoods.newTab().setText(name2));
        }

        mTabGoods.getTabAt(posi).select();
        mPresenter.getData(id);
        mTabGoods.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                List<GoodsResult.DataBeanX.DataBean> data = adapter.getData();
                if(data!=null&&data.size()>0){
                    data.clear();
                }
                mPresenter.getData(integers.get(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTabId() {
        integers = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            integers.add(data.get(i).getId());
        }
    }

    private void initTab() {
        tabs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String name2 = data.get(i).getName();
            tabs.add(name2);
        }
    }

    @Override
    public void setData(GoodsResult goodsResult) {
        data1 = goodsResult.getData().getData();
        if (data!=null && data.size()>0){
            adapter.addData(data1);
        }
        setHead();

    }



    private void setHead() {
        final TextView name1 = inflate.findViewById(R.id.head_name);
        final TextView desc = inflate.findViewById(R.id.head_desc);
        name=data.get(position).getFront_desc();
        desc.setText(name);
        name1.setText(tabs.get(position));
    }

    private void addHead() {
        inflate = getLayoutInflater().inflate(R.layout.head_goods, null);
        adapter.addHeaderView(inflate);
    }
   /* if(data!=null&&data.size()>0){
        Log.d("在这里", "setData: "+"达影城");
        adapter = new GoodsAdapter(R.layout.fragment_goodsadapter, data1);
        mResGoods.setAdapter(adapter);
        View inflate = getLayoutInflater().inflate(R.layout.head_goods, null);
        final TextView name1 = inflate.findViewById(R.id.head_name);
        final TextView desc = inflate.findViewById(R.id.head_desc);
        name=data.get(position).getFront_desc();
        desc.setText(name);
        name1.setText(tabs.get(position));
        adapter.addHeaderView(inflate);
    }*/
}
