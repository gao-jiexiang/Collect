package com.example.collect.ui.topic;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collect.R;
import com.example.collect.base.BaseApp;
import com.example.collect.base.BaseRlvAdapter;
import com.example.collect.bean.TopicBean;

import java.util.ArrayList;

public class RlvTopicAdapter2 extends BaseRlvAdapter<TopicBean.DataBeanX.DataBean> {
    String yuan = BaseApp.getRes().getString(R.string.yuan);
    public RlvTopicAdapter2(Context context, ArrayList list) {
        super(context, list);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_topic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, TopicBean.DataBeanX.DataBean dataBean) {
        /*TextView tv = (TextView) holder.findView(R.id.tv);
        tv.setText(dataBean.getTitle());*/

        holder.setText(R.id.tv_title,dataBean.getTitle());
        holder.setText(R.id.tv_subtitle,dataBean.getSubtitle());
        holder.setText(R.id.tv_price,dataBean.getPrice_info()+yuan);
        ImageView iv = (ImageView) holder.findView(R.id.iv);
        Glide.with(mContext).load(dataBean.getScene_pic_url()).into(iv);
    }
}
