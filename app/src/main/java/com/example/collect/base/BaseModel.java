package com.example.collect.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract  class BaseModel {
    ///这个是rxjava专门提供的一个存储disposable对象的容器
    CompositeDisposable mCompositeDisposable ;
    public  void destroy(){
        //disposable.dispose();
        if (mCompositeDisposable != null){
            //这个容器的clear方法会把容器中所有的disposable对象取出来,调用dispose()
            mCompositeDisposable.clear();
        }
    }


    //子类中进行网络请求的disposable对象,添加disposable对象到容器中
    public void addDisposable(Disposable disposable){

        if (mCompositeDisposable  == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
