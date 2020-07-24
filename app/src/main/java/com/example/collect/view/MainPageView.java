package com.example.collect.view;


import com.example.collect.base.BaseView;
import com.example.collect.bean.MainBean;

public interface MainPageView extends BaseView {
    void setData(MainBean mainBean);
    void show(String msg);
}
