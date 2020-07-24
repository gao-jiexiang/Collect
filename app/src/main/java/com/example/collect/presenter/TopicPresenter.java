package com.example.collect.presenter;


import com.example.collect.base.BasePresenter;
import com.example.collect.base.Constants;
import com.example.collect.bean.TopicBean;
import com.example.collect.model.TopicModel;
import com.example.collect.net.ResultCallBack;
import com.example.collect.view.TopicView;

public class TopicPresenter extends BasePresenter<TopicView> {

    private TopicModel mTopicModel;

    @Override
    protected void initModel() {
        mTopicModel = new TopicModel();
        addModel(mTopicModel);
    }

    public void getTopic(int page, int size) {
        mTopicModel.getTopic(page,size, new ResultCallBack<TopicBean>() {
            @Override
            public void onSuccess(TopicBean topicBean) {
                if (topicBean.getErrno() == Constants.SUCCESS_CODE){
                    //请求成功
                    if (topicBean.getData().getData()!=null && topicBean.getData().getData().size()>0){
                        mView.setTopic(topicBean.getData());
                    }

                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
