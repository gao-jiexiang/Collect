package com.example.collect.ui.cart;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collect.R;
import com.example.collect.base.BaseApp;
import com.example.collect.base.BaseFragment;
import com.example.collect.bean.AddCart;
import com.example.collect.bean.CartListBean;
import com.example.collect.bean.CheckEvent;
import com.example.collect.bean.UpdateGoodsEvent;
import com.example.collect.db.CartListBeanDao;
import com.example.collect.presenter.CartPresenter;
import com.example.collect.view.CartView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class CartFragment extends BaseFragment<CartPresenter> implements CartView {

    public static final int TYPE_ORDER=0;//下单状态
    private static final int TYPE_EDIT=1;//编辑状态

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.cb_choose)
    CheckBox mCb;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_order)
    TextView mTvOrder;
    @BindView(R.id.tv_edit)
    TextView mTvEdit;
    @BindView(R.id.cl_bottom)
    ConstraintLayout mClBottom;
    private RlvCartAdapter adapter;
    String mStrAll= BaseApp.getRes().getString(R.string.choose_all);
    String rmb= BaseApp.getRes().getString(R.string.rmb);

    //当前状态
    public int mCurrentState = TYPE_ORDER;
    private int mCheckedGoodsCount;
    private CartListBeanDao mCartListBeanDao1;

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        return fragment;
    }

    @Override
    protected CartPresenter initPresenter() {
        return new CartPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getCartData();

    }

    @Override
    protected void initView(View view) {
        mCartListBeanDao1 = BaseApp.getInstance().getDaoSession().getCartListBeanDao();
        List<CartListBean> dbList = mCartListBeanDao1.queryBuilder().list();
        if (dbList != null && dbList.size()>0){
            ArrayList<Integer> ids = new ArrayList<>();
            for (int i = 0; i < dbList.size(); i++) {
                boolean isServerDelete = dbList.get(i).getIsServerDelete();
                if (isServerDelete){
                    ids.add(dbList.get(i).getProduct_id());
                }
            }

            if (ids.size()>0){
                mPresenter.deleteGoods(ids);
            }
        }
//哪里出错了
        mCartListBeanDao1 = BaseApp.sContext.getDaoSession().getCartListBeanDao();
        //根据状态
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        ArrayList<CartListBean> mList=new ArrayList<>();
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RlvCartAdapter(R.layout.item_cart, mList);
        adapter.bindToRecyclerView(mRlv);

       mCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
               if (compoundButton.isPressed()){
                   List<CartListBean> data = adapter.getData();


                   if (mCurrentState ==TYPE_ORDER){
                       //下单
                       int ck = isChecked ? 1 : 0;
                       for (int i = 0; i < data.size(); i++) {
                           data.get(i).setChecked(ck);
                       }
                   }else {
                        //编辑状态
                           for (int i = 0; i < data.size(); i++) {
                               data.get(i).setEditChecked(isChecked);
                           }
                   }

                   adapter.notifyDataSetChanged();

                   //还需要修改总价和选中的商品数量
                   int count = 0;
                   float totalPrice = 0;
                   if (isChecked){
                       for (int i = 0; i < data.size(); i++) {
                           count += data.get(i).getNumber();
                           totalPrice +=data.get(i).getNumber()* data.get(i).getRetail_price();
                       }
                   }
                   setChooseGoodsNum(count);
                   if (mCurrentState ==TYPE_ORDER){
                       setTotalPrice(totalPrice);
                   }
               }
           }
       });


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cart;
    }

    @OnClick({R.id.tv_order, R.id.tv_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order:
                orderOrDelete();
                break;
            case R.id.tv_edit:
                chageState();
                break;
        }
    }

    //下单或删除
    private void orderOrDelete() {
        if (mCurrentState ==TYPE_ORDER){
            //下单
            if (mCheckedGoodsCount>0){
                //选中至少一个商品
                go2Order();
            }else {
                showToast("请至少选中一个商品");
            }
        }else {
            //请求接口之前至少有一个商品选中
            if (mCheckedGoodsCount <= 0){
                showToast("请至少选中一个商拼");
                return;
            }
            //删除
            //将编辑状态下选中的商品id拼接起来
            List<CartListBean> data = adapter.getData();
            ArrayList<Integer> ids = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                CartListBean cartListBean = data.get(i);
                boolean editChecked = cartListBean.getEditChecked();
                if (editChecked){
                    ids.add(cartListBean.getProduct_id());

                    //添加要被删除的标识
                    cartListBean.setIsServerDelete(true);
                    mCartListBeanDao1.update(cartListBean);
                    data.remove(i);
                    i--;
                }
            }
            setChooseGoodsNum(0);
            mCb.setChecked(false);
            //种种情况下需要结合本地数据库
            //没每次请求服务器成功之后，将数据库保存你到本地数据库，
            //并且给一个标识，等服务器杀出成功之后，在吧本地
            //如果不成功，本地数据先不删，等网络好的情况下

            adapter.notifyDataSetChanged();
            mPresenter.deleteGoods(ids);
        }
    }

    private void go2Order() {
        showToast("跳转到下单页面");
    }

    //修改编辑或下单状态
    private void chageState() {
        if (mCurrentState ==TYPE_ORDER){
            //修改状态
            mCurrentState =TYPE_EDIT;
        }else {
            mCurrentState=TYPE_ORDER;
        }
        //修改fragment界面
        chageUI();
    }

    private void chageUI() {
        //总价
        if (mCurrentState ==TYPE_ORDER){
            mTvPrice.setVisibility(View.VISIBLE);
            mTvEdit.setText("编辑");
            mTvOrder.setText("下单");
            receiveCheckEvent(new CheckEvent());
        }else {
            mTvPrice.setVisibility(View.GONE);
            mTvEdit.setText("完成");
            mTvOrder.setText("删除所选");

            List<CartListBean> data = adapter.getData();
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setEditChecked(false);
            }
            setChooseGoodsNum(0);
            mCb.setChecked(false);

            //点击完成，修改商品数量

        }
        adapter.setState(mCurrentState);
    }

    @Subscribe
    public void receivedModifGoodsNum(UpdateGoodsEvent event){
        mPresenter.updateNumber(event.productId,event.goodsId,event.number,event.id);
    }

    @Override
    public void setCardData(AddCart addCart) {
        //好了还有哪里
        List<CartListBean> cartList = addCart.getData().getCartList();
        adapter.addData(cartList);
        boolean checkedAll=true;
        for (int i = 0; i < cartList.size(); i++) {
            CartListBean cartListBean = cartList.get(i);
            if(cartListBean.getChecked()==0){
                checkedAll=false;
            }
        }
        mCb.setChecked(checkedAll);
        AddCart.DataBean.CartTotalBean cartTotal = addCart.getData().getCartTotal();
        int checkedGoodsCount = cartTotal.getCheckedGoodsCount();
        setChooseGoodsNum(checkedGoodsCount);

        //金额
        float text =  cartTotal.getCheckedGoodsAmount();
        setTotalPrice( text);
    }

    //设置金额
    private void setTotalPrice(float price) {
        mTvPrice.setText(rmb +price);
    }

    //设置选中商品数量的
    private void setChooseGoodsNum(int checkedGoodsCount) {
        if (checkedGoodsCount > 0) {
            mCb.setText(mStrAll + "(" + checkedGoodsCount + ")");
        }else {
            mCb.setText(mStrAll);
        }

        //保存选中商品的数量
        this.mCheckedGoodsCount = checkedGoodsCount;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void receiveCheckEvent(CheckEvent event){
        //修改选中商品的数量+总价
        //数量
        List<CartListBean> data = adapter.getData();
        int count = 0;
        float totalPrice = 0;
        //确定全选的状态
        boolean isChecked = true;
        for (int i = 0; i < data.size(); i++) {
            CartListBean cartListBean = data.get(i);
            if (mCurrentState == TYPE_ORDER){
                if (cartListBean.getChecked() == 1){
                    //计算数量
                    count += cartListBean.getNumber();
                    totalPrice += cartListBean.getNumber() * cartListBean.getRetail_price();
                }else {
                    //子条目只要有一个商品未选中，全选不选中
                    isChecked = false;
                }
            }else {
                //编辑状态
                if (cartListBean.getEditChecked()){
                    //计算数量
                    count += cartListBean.getNumber();
                }else {
                    isChecked = false;
                }
            }

        }
        setChooseGoodsNum(count);
        setTotalPrice(totalPrice);
        //设置全选状态
        mCb.setChecked(isChecked);
    }



}
