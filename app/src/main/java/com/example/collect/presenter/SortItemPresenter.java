package com.example.collect.presenter;


import com.example.collect.base.BasePresenter;
import com.example.collect.bean.SortItemBean;
import com.example.collect.model.SortItemModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.SortItemView;

public class SortItemPresenter extends BasePresenter<SortItemView> {

    private SortItemModel model;

    @Override
    protected void initModel() {
        model = new SortItemModel();
        addModel(model);
    }

    public void getData(int id) {
        model.getData(id, new ResultCallBack<SortItemBean>() {
            @Override
            public void onSuccess(SortItemBean sortItemBean) {
                mView.setData(sortItemBean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
