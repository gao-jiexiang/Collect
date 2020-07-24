package com.example.collect.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.collect.db.DaoMaster;
import com.example.collect.db.DaoSession;
import com.example.collect.util.SpUtil;


//app一上来会先走application是有条件的,要求app原来所在的进程被杀死才会走,
//如果仅仅是activity销毁了,不一定走
//Android 系统为了提高app启动的速度,在界面销毁之后,进程不会被杀死, 而是变成一个空进程
public class BaseApp extends Application {
    public static BaseApp sContext;
    public static boolean isLogin;
    public static String mToken;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static Resources getRes() {
        return sContext.getResources();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        mToken = (String) SpUtil.getParam(Constants.TOKEN, "");
        if (TextUtils.isEmpty(mToken)) {
            isLogin = false;
        }else {
            isLogin = true;
        }
        setDatabase();
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {

        //通过DaoMaster内部类DevOpenHelper可以获取一个SQLiteOpenHelper 对象

        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。

        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。

        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。

        // 此处MyDb表示数据库名称 可以任意填写,需要加尾缀.db

        mHelper = new DaoMaster.DevOpenHelper(this, "MyDb.db", null);

        SQLiteDatabase db = mHelper.getWritableDatabase();

        //Android 9 默认使用了wal模式,需要关闭wal模式
        db.disableWriteAheadLogging();

        mDaoMaster = new DaoMaster(db);

        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }
    public static BaseApp getInstance(){
        return sContext;
    }
}
