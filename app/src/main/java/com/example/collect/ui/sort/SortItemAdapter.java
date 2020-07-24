package com.example.collect.ui.sort;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.collect.R;
import com.example.collect.base.BaseRlvAdapter;
import com.example.collect.bean.SortItemBean;


import java.util.ArrayList;
import java.util.List;

import com.chad.library.adapter.base.BaseViewHolder;

public class SortItemAdapter extends BaseQuickAdapter<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean, BaseViewHolder> {

    private final Context context;
    public SortItemAdapter(Context context,int layoutResId, @Nullable List<SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean> data) {
        super(layoutResId, data);

        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SortItemBean.DataBean.CurrentCategoryBean.SubCategoryListBean item) {
        helper.setText(R.id.rec_tv,item.getName());
        ImageView imageView = helper.getView(R.id.rec_Img);
        Glide.with(context).load(item.getWap_banner_url()).into(imageView);

        /*//控件,数据
        //找控件
        ImageView iv = helper.getView(R.id.iv);
        Glide.with(mContext).load(item.getWap_banner_url()).into(iv);
        helper.setText(R.id.tv,item.getName());*/
    }
}
