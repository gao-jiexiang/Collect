package com.example.collect.presenter;


import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.SortTabBean;
import com.example.collect.model.SortModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.SortView;

public class SortPresenter extends BasePresenter<SortView> {

    private SortModel mSortModel;

    @Override
    protected void initModel() {
        mSortModel = new SortModel();
        addModel(mSortModel);
    }

    public void getTab() {
        mSortModel.getTab(new ResultCallBack<SortTabBean>() {
            @Override
            public void onSuccess(SortTabBean sortTabBean) {
                if (sortTabBean.getErrno()== Constants.SUCCESS_CODE){
                    //no是0的时候代表成功
                    mView.setTab(sortTabBean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
