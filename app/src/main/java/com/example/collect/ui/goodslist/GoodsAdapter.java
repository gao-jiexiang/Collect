package com.example.collect.ui.goodslist;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.collect.R;
import com.example.collect.bean.GoodsResult;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<GoodsResult.DataBeanX.DataBean, BaseViewHolder> {

    public GoodsAdapter(int layoutResId, @Nullable List<GoodsResult.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsResult.DataBeanX.DataBean item) {
        helper.setText(R.id.goods_price,"¥"+item.getRetail_price());
        helper.setText(R.id.goods_name,item.getName());
        ImageView image = helper.getView(R.id.good_img);
        Glide.with(mContext).load(item.getList_pic_url()).into(image);
    }
}
