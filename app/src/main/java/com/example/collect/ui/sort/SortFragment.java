package com.example.collect.ui.sort;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.example.collect.R;
import com.example.collect.base.BaseFragment;
import com.example.collect.bean.SortTabBean;
import com.example.collect.presenter.SortPresenter;
import com.example.collect.util.LogUtil;
import com.example.collect.view.SortView;

import java.util.ArrayList;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.SimpleTabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;


public class SortFragment extends BaseFragment<SortPresenter> implements SortView {

    @BindView(R.id.tablayout)
    VerticalTabLayout mTablayout;
    @BindView(R.id.vp)
    ViewPager2 mVp;
    private SortTabBean mSortTabBean;

    public static SortFragment newInstance() {
        SortFragment fragment = new SortFragment();
        return fragment;
    }

    @Override
    protected SortPresenter initPresenter() {
        return new SortPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getTab();

    }

    @Override
    protected void initView(View view) {
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                //tab选中
                //切换viewpager的页面
                mVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {
                //tab重复选中
            }
        });

        //viewpager2的翻页监听
        mVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                //页面选中
                //tab选中
                LogUtil.print("onPageSelected:"+position);
                mTablayout.setTabSelected(position);
                //new TabLayout().getTabAt(position).select();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    public void setTab(SortTabBean sortTabBean) {
        this.mSortTabBean = sortTabBean;
        initTab();
        initVp();
    }

    private void initVp() {
        ArrayList<BaseFragment> list = new ArrayList<>();
        for (int i = 0; i < mSortTabBean.getData().getCategoryList().size(); i++) {
            String name = mSortTabBean.getData().getCategoryList().get(i).getName();
            int id = mSortTabBean.getData().getCategoryList().get(i).getId();
            list.add(SortItemFragment.newInstance(name,id));
        }
        VpSortAdapter adapter = new VpSortAdapter(getActivity(),list);
        mVp.setAdapter(adapter);
    }

    private void initTab() {
        mTablayout.setTabAdapter(new SimpleTabAdapter() {
            @Override
            public int getCount() {
                return mSortTabBean.getData().getCategoryList().size();
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                SortTabBean.DataBean.CategoryListBean listBean = mSortTabBean.getData().getCategoryList().get(position);
                return new ITabView.TabTitle.Builder()
                        .setContent(listBean.getName())
                        .build();
            }
        });
    }
}
