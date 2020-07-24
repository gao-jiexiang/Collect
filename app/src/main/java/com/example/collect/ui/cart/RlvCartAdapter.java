package com.example.collect.ui.cart;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.collect.R;
import com.example.collect.base.BaseApp;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.CartListBean;
import com.example.collect.bean.CheckEvent;
import com.example.collect.bean.UpdateGoodsEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class RlvCartAdapter extends BaseQuickAdapter<CartListBean, BaseViewHolder> {
    String rmb = BaseApp.getRes().getString(R.string.rmb);
    private int type;
    public boolean mIsModifNumber =false;//是否修改过商品数量


    public RlvCartAdapter(int layoutResId, @Nullable List<CartListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CartListBean item) {
        //根据状态设置界面
        TextView mTvCount = helper.getView(R.id.tv_count);
        LinearLayout llConstainer = helper.getView(R.id.ll_container);
        TextView tvNumber = helper.getView(R.id.tv_number);
        TextView tvMinus = helper.getView(R.id.tv_minus);
        TextView tvPlus = helper.getView(R.id.tv_plus);

        helper.setText(R.id.tv_goods_price,rmb+item.getRetail_price());
        helper.setText(R.id.tv_goods_name,item.getGoods_name());
        helper.setText(R.id.tv_count,"x"+item.getNumber());
        CheckBox cb = helper.getView(R.id.cb);
        Glide.with(mContext).load(item.getList_pic_url()).into((ImageView) helper.getView(R.id.iv_goods));

        if (type ==CartFragment.TYPE_ORDER){
            int checked = item.getChecked();
            if (checked ==1){
                cb.setChecked(true);
            }else {
                cb.setChecked(false);
            }
            mTvCount.setVisibility(View.VISIBLE);
            //加减商品数量
            llConstainer.setVisibility(View.GONE);
        }else {
            //编辑状态
            boolean editChecked = item.getEditChecked();
            cb.setChecked(editChecked);

            mTvCount.setVisibility(View.GONE);
            //加减商品数量
            llConstainer.setVisibility(View.VISIBLE);

            tvNumber.setText(item.getNumber()+"");
        }


        //
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isPressed()){
                    if (type ==CartFragment.TYPE_ORDER){
                        int ck= isChecked ? 1 : 0;
                        item.setChecked(ck);
                    } else {
                        item.setEditChecked(isChecked);
                    }
                    //用户修改状态后需要通知framgnet修改选中商品的数量+总价,确定全选的状态
                    EventBus.getDefault().post(new CheckEvent());
                }
            }
        });
        //-
        tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = item.getNumber();
                if (number>1){
                    tvNumber.setText(number-1+"");
                    item.setNumber(number-1);

                    //将数据同步到服务器
                    //为了避免平凡的调用修改商品数量的接口
                    //调用接口
                    mIsModifNumber =true;

                    EventBus.getDefault().post(new UpdateGoodsEvent(item.getProduct_id(),
                            item.getGoods_id(),item.getNumber(),item.getId()));

                }
            }
        });
        //+
        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果有库存的话，数量不能超过库存上限
                item.setNumber(item.getNumber()+1);
                tvNumber.setText(item.getNumber()+"");

                //将数据同步到服务器
                mIsModifNumber =true;

                EventBus.getDefault().post(new UpdateGoodsEvent(item.getProduct_id(),
                        item.getGoods_id(),item.getNumber(),item.getId()));
            }
        });
    }

    public void setState(int mCurrentState) {
        this.type = mCurrentState;
        notifyDataSetChanged();
    }


}
