package com.example.collect.view;

import com.example.collect.base.BaseView;
import com.example.collect.bean.LoginBean;

public interface LoginView extends BaseView {
    void show(String msg);
    void loginSuccess(LoginBean loginBean);
}
