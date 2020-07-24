package com.example.collect.presenter;

import com.example.collect.base.BasePresenter;
import com.example.collect.bean.RegisterBean;
import com.example.collect.model.RegistModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.CartView;
import com.example.collect.view.RegistView;

public class RegistPresenter extends BasePresenter<RegistView> {

    private RegistModel registModel;

    @Override
    protected void initModel() {
        registModel = new RegistModel();
        addModel(registModel);
    }

    public void getData(String name, String pass) {
        registModel.getData(name,pass, new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                int errno = registerBean.getErrno();
                if(errno==0){
                    mView.show("注册成功");
                }else {
                    mView.show(registerBean.getErrmsg());
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
