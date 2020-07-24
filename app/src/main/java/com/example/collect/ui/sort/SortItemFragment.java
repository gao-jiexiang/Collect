package com.example.collect.ui.sort;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.collect.R;
import com.example.collect.base.BaseFragment;
import com.example.collect.base.Constants;
import com.example.collect.bean.SortItemBean;
import com.example.collect.presenter.SortItemPresenter;
import com.example.collect.ui.goodslist.GoodsListActivity;
import com.example.collect.view.SortItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortItemFragment extends BaseFragment<SortItemPresenter> implements SortItemView {
    /*@BindView(R.id.text)
    TextView text;*/
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private int id;
    private String mTitle;
    private SortItemAdapter adapter;
    private ImageView mIv;

    public static SortItemFragment newInstance(String title, int id) {
        SortItemFragment fragment = new SortItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, title);
        bundle.putInt(Constants.ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected SortItemPresenter initPresenter() {
        return new SortItemPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getData(id);
    }

    @Override
    protected void initView(View view) {
        mTitle = getArguments().getString(Constants.DATA);
        id = getArguments().getInt(Constants.ID);
        mRlv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        /*ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list = new ArrayList<>();
        adapter = new SortItemAdapter(R.layout.item_sort_item, list);
        mRlv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //
        //mRlv.setAdapter(adapter);
        */

        //addHeader();



    }




  /*  private void addHeader() {
        //添加头布局
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_sort_header, null);
        TextView tv = inflate.findViewById(R.id.tv);
        tv.setText("-- "+mTitle+"分类 --");
        mIv = inflate.findViewById(R.id.iv);
        adapter.addHeaderView(inflate);
    }*/

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort_item;
    }

    @Override
    public void setData(SortItemBean sortItemBean) {
        ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = (ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean>) sortItemBean.getData().getCurrentCategory().getSubCategoryList();
        adapter = new SortItemAdapter(getActivity(), R.layout.adapter, subCategoryList);
        mRlv.setAdapter(adapter);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.head, null);
        ImageView image= inflate.findViewById(R.id.head_img);
        Glide.with(getActivity()).load(sortItemBean.getData().getCurrentCategory().getBanner_url()).into(image);
        TextView text = inflate.findViewById(R.id.head_tv);
        TextView im_tv = inflate.findViewById(R.id.img_tv);
        im_tv.setText(sortItemBean.getData().getCurrentCategory().getFront_name());
        text.setText("——"+sortItemBean.getData().getCurrentCategory().getName()+"分类"+"——");
        adapter.addHeaderView(inflate);

        //子条目点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = subCategoryList.get(position);
                int noew_id = subCategoryListBean.getId();
                String front_name = subCategoryListBean.getFront_desc();
                String userName = subCategoryListBean.getName();
                goGoods(noew_id,position,front_name,userName);
            }
        });

       /* adapter.addData(sortItemBean.getData().getCurrentCategory().getSubCategoryList());
        Glide.with(getContext()).load(sortItemBean.getData().getCurrentCategory().getBanner_url()).into(mIv);*/
    }

    private void goGoods(int id, int position, String name, String userName) {
        Intent intent = new Intent(getActivity(), GoodsListActivity.class);
        intent.putExtra(Constants.POSITION,position);
        intent.putExtra(Constants.ID,id);
        intent.putExtra(Constants.USERNAME,name);
        intent.putExtra(Constants.DATA, (ArrayList<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean>)adapter.getData());
        startActivity(intent);
    }
}
