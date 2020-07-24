package com.example.collect.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.BaseApp;
import com.example.collect.base.BaseFragment;
import com.example.collect.presenter.MainPresenter;
import com.example.collect.ui.cart.CartFragment;
import com.example.collect.ui.mainpage.MainPageFragment;
import com.example.collect.ui.me.MeFragment;
import com.example.collect.ui.sort.SortFragment;
import com.example.collect.ui.topic.TopicFragment;
import com.example.collect.view.MainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {


    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    private ArrayList<String> mTitles;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Integer> mImages;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        initTitles();
        initImages();
        initFragments();
        VpMainAdapter adapter = new VpMainAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mVp.setAdapter(adapter);
        //viewpager 的适配器会帮我们创建tab,但是只有标题,没有图片
        mTabLayout.setupWithViewPager(mVp);
        //把已有的tab换成我们想要的图文形式就可以了
        for (int i = 0; i < mTitles.size(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            //设置自定义布局
            tab.setCustomView(getTabView(i));
        }
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(MainPageFragment.newInstance());
        mFragments.add(TopicFragment.newInstance());
        mFragments.add(SortFragment.newInstance());
        mFragments.add(CartFragment.newInstance());
        mFragments.add(MeFragment.newInstance());
    }

    //根据索引获取对应的tab的自定义view
    private View getTabView(int position) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        TextView tv = inflate.findViewById(R.id.tv);
        ImageView iv = inflate.findViewById(R.id.iv);
        tv.setText(mTitles.get(position));
        iv.setImageResource(mImages.get(position));
        return inflate;
    }

    //图片
    private void initImages() {
        mImages = new ArrayList<>();
        mImages.add(R.drawable.se_main_page);
        mImages.add(R.drawable.se_topic);
        mImages.add(R.drawable.se_sort);
        mImages.add(R.drawable.se_cart);
        mImages.add(R.drawable.se_me);

    }

    //tab标题
    private void initTitles() {
        mTitles = new ArrayList<>();
        //开发过程中避免使用硬编码,使用资源文件
        mTitles.add(BaseApp.getRes().getString(R.string.main_page));
        mTitles.add(BaseApp.getRes().getString(R.string.topic));
        mTitles.add(BaseApp.getRes().getString(R.string.sort));
        mTitles.add(BaseApp.getRes().getString(R.string.cart));
        mTitles.add(BaseApp.getRes().getString(R.string.me));

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


}
