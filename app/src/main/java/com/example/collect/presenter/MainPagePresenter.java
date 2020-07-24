package com.example.collect.presenter;


import com.example.collect.base.BasePresenter;
import com.example.collect.bean.MainBean;
import com.example.collect.model.MainModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.MainPageView;

public class MainPagePresenter extends BasePresenter<MainPageView> {

    private MainModel model;

    @Override
    protected void initModel() {
        model = new MainModel();
        addModel(model);
    }


    public void getData() {
        model.getDate(new ResultCallBack<MainBean>() {
            @Override
            public void onSuccess(MainBean mainBean) {
                mView.setData(mainBean);
            }

            @Override
            public void onFail(String msg) {
                mView.show(msg);
            }
        });
    }
}
