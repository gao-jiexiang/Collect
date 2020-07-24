package com.example.collect.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.collect.util.ToastUtil;

import java.net.NetPermission;

import butterknife.ButterKnife;

//模板方法模式:父类定义代码的执行流程,把一些无法决定的东西放到子类完成
//相同的代码抽取到父类里面
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //butterknife,findviewbyid,添加监听
        ButterKnife.bind(this);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消订阅关系v和p的关联
        //打断网络请求+
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToastShort(msg);
    }
}
