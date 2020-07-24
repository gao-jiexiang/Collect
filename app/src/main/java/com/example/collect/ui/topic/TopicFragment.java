package com.example.collect.ui.topic;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collect.R;
import com.example.collect.base.BaseFragment;
import com.example.collect.base.BaseRlvAdapter;
import com.example.collect.bean.TopicBean;
import com.example.collect.presenter.TopicPresenter;
import com.example.collect.util.ToastUtil;
import com.example.collect.view.TopicView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TopicFragment extends BaseFragment<TopicPresenter> implements TopicView {

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    private int mPage = 1;
    private int mSize = 10;
    private RlvTopicAdapter2 mAdapter;
    private int mTotalPages;

    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        return fragment;
    }

    @Override
    protected TopicPresenter initPresenter() {
        return new TopicPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getTopic(mPage, mSize);
    }

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<TopicBean.DataBeanX.DataBean> list = new ArrayList<>();
        mAdapter = new RlvTopicAdapter2(getContext(), list);
        mRlv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseRlvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //子条目的点击事件
                ToastUtil.showToastShort("点击position"+position);
            }
        });

        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //下载更多
                //加载更多
                if (mPage < mTotalPages) {
                    //如果当前页面比数据总页数小
                    mPage++;
                    mPresenter.getTopic(mPage, mSize);
                }else {
                    ToastUtil.showToastShort("没有更多数据了");
                    mSrl.finishLoadMore();
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //下拉刷新
                mPage = 1;
                mAdapter.mList.clear();
                mPresenter.getTopic(mPage, mSize);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    public void setTopic(TopicBean.DataBeanX bean) {
        mAdapter.addData(bean.getData());
        //数据回来后结束下拉和上拉
        mSrl.finishLoadMore();
        mSrl.finishRefresh();

        mTotalPages = bean.getTotalPages();
    }
}
