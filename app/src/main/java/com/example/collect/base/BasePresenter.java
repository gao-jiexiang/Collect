package com.example.collect.base;

import com.example.collect.presenter.MainPresenter;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {

    private ArrayList<BaseModel> mBaseModels ;
    public BasePresenter(){
        initModel();
    }
    //专门用来初始化M层的方法
    protected abstract void initModel();

    public V mView;

    //V和P层的关联
    public void attachView(V view){
        this.mView=view;
    }
    //取消关联
    public void detachView(){
        //取消v和p的关联
        mView = null;
        //打断网络请求+订阅关系
        if (mBaseModels!=null){
            for (int i = 0; i < mBaseModels.size(); i++) {
                //通知m层取消网络请求+打断订阅关系
                mBaseModels.get(i).destroy();
            }
        }

    }

    //把创建出来的m层对象添加到容器中
    public void addModel(BaseModel model){
        if (mBaseModels == null){
            mBaseModels = new ArrayList<>();
        }
        mBaseModels.add(model);
    }
}
