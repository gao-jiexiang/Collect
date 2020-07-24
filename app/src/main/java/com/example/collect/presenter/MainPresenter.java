package com.example.collect.presenter;

import com.example.collect.base.BasePresenter;
import com.example.collect.model.MainModel;
import com.example.collect.view.MainView;

public class MainPresenter extends BasePresenter <MainView> {
    private MainModel mMainModel;

    public void getData(){
        mMainModel.getData();
    }

    @Override
    protected void initModel() {
        mMainModel=new MainModel();
        addModel(mMainModel);
    }
}
