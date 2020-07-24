package com.example.collect.ui.me;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collect.R;
import com.example.collect.base.BaseApp;
import com.example.collect.base.BaseFragment;
import com.example.collect.base.Constants;
import com.example.collect.bean.LoginBean;
import com.example.collect.presenter.MePresenter;
import com.example.collect.ui.login.ExitLoginActivity;
import com.example.collect.ui.login.LoginActivity;
import com.example.collect.util.SpUtil;
import com.example.collect.view.MeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;


public class MeFragment extends BaseFragment<MePresenter> implements MeView {

    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv_name)
    TextView mTvName;

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    protected MePresenter initPresenter() {
        return new MePresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        if(BaseApp.isLogin){
            String name = (String) SpUtil.getParam(Constants.USERNAME, "未登录");
            mTvName.setText(name);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
    }

    @OnClick({R.id.iv,R.id.tv_name})
    public void click(View v){
       /* //判断条件看本地是否有存储token，如果有，代码登录
        String  token = (String) SpUtil.getParam(Constants.TOKEN, "");
        if (TextUtils.isEmpty(token)){
            go2Login();
        }*/
       if (!BaseApp.isLogin){
           go2Login();
       }else {
           exitLogin();
       }
    }

    //注册
    private void exitLogin() {
        Intent intent = new Intent(getActivity(), ExitLoginActivity.class);
        startActivity(intent);
    }

    //登录
    private void go2Login() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Subscribe
    public void receive(String name){
        if (name.equals("未登录")){
            BaseApp.isLogin=false;
            SpUtil.setParam(Constants.USERNAME,"未登录");
        }else{
            BaseApp.isLogin=true;
        }
        mTvName.setText(name);
        /*//设置用户名
        mTvName.setText(loginBean.getData().getUserInfo().getNickname());
        //登录了避免再次点击的时候跳转登录页面*/
    }


    @Subscribe
    public void receiveLogin(LoginBean loginBean) {
        //设置用户名
        mTvName.setText(loginBean.getData().getUserInfo().getNickname());
        //登录了避免再次点击的时候跳转登录页面
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
