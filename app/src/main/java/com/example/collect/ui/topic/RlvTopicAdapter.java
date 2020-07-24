package com.example.collect.ui.topic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collect.R;
import com.example.collect.bean.TopicBean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvTopicAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final ArrayList<TopicBean.DataBeanX.DataBean> mList;

    public RlvTopicAdapter(Context context, ArrayList<TopicBean.DataBeanX.DataBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.tab, parent, false);

        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH) holder;
        vh.mTv.setText(mList.get(position).getTitle());
        Glide.with(mContext).load(mList.get(position).getScene_pic_url()).into(vh.mIv);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<TopicBean.DataBeanX.DataBean> bean) {
        mList.addAll(bean);
        notifyDataSetChanged();
    }

    class VH extends RecyclerView.ViewHolder{
        @BindView(R.id.tv)
        TextView mTv;
        @BindView(R.id.iv)
        ImageView mIv;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
