package com.example.collect.presenter;

import android.telephony.MbmsGroupCallSession;

import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.LoginBean;
import com.example.collect.model.LoginModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.util.SpUtil;
import com.example.collect.view.CartView;
import com.example.collect.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
        addModel(loginModel);
    }

    public void login(String name, String pw) {
        loginModel.login(name,pw, new ResultCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if(loginBean.getErrno() == Constants.SUCCESS_CODE){
                    //请求成功并不代表登陆成功
                    if (loginBean.getData().getCode()==200){
                        //登录成功,保存用户的信息
                        saveUserInfo(loginBean);
                        mView.showToast("登录成功");
                        mView.loginSuccess(loginBean);
                    }else {
                        mView.showToast(loginBean.getData().getMsg());
                    }

                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    private void saveUserInfo(LoginBean loginBean) {
        SpUtil.setParam(Constants.TOKEN,loginBean.getData().getToken());
        SpUtil.setParam(Constants.USERNAME,loginBean.getData().getUserInfo().getNickname());
    }

}
