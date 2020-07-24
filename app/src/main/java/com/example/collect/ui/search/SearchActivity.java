package com.example.collect.ui.search;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.BaseApp;
import com.example.collect.bean.HistroyBean;
import com.example.collect.db.HistroyBeanDao;
import com.example.collect.presenter.SearchPresenter;
import com.example.collect.util.LogUtil;
import com.example.collect.view.SearchView;
import com.example.collect.widget.FlowLayout;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView {

    @BindView(R.id.et)
    EditText mEt;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_history_title)
    TextView mTvHistoryTitle;
    @BindView(R.id.iv_delete)
    ImageView mIvDelete;
    @BindView(R.id.fl_history)
    FlowLayout mFlHistory;
    @BindView(R.id.tv_hot_title)
    TextView mTvHotTitle;
    @BindView(R.id.fl_hot)
    FlowLayout mFlHot;
    @BindView(R.id.cl_record)
    ConstraintLayout mClRecord;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.cl_result)
    ConstraintLayout mClResult;
    private HistroyBeanDao mHistroyBeanDao;
    private List<HistroyBean> list;

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initView() {
        mHistroyBeanDao = BaseApp.sContext.getDaoSession().getHistroyBeanDao();
        //edittext 文本改变监听
        getHistoryFromDb();
        initListener();
    }

    private void getHistoryFromDb() {
        List<HistroyBean> list = mHistroyBeanDao.queryBuilder().list();
        if (list!=null && list.size()>0){
            //根据搜索的时间排序
            Collections.sort(list, new Comparator<HistroyBean>() {
                @Override
                public int compare(HistroyBean histroyBean, HistroyBean t1) {
                    //升序时间大在前面，返回大于0 的数
                    return (int)(t1.time-histroyBean.time);
                }
            });
            //界面上展示
            mFlHistory.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.item_iabel, null, false);
                tv.setText(list.get(i).keyword);
                mFlHistory.addView(tv);
            }
        }
    }

    private void initListener() {
        mEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //文本改变之前
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //文本发生改变
                LogUtil.print("文本："+charSequence);
                //如果文本内容为空，显示搜索历史，如果不为空，显示搜索结果
                if (TextUtils.isEmpty(charSequence)){
                    mClRecord.setVisibility(View.VISIBLE);
                    mClResult.setVisibility(View.GONE);
                }else {
                    mClRecord.setVisibility(View.GONE);
                    mClResult.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //文本改变之后
            }
        });

        mEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH){
                    showToast("搜索");
                    //根据输入内容搜索
                    search();
                }
                return false;
            }
        });

    }

    private void search() {
        String content = mEt.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("搜索内容不能为空");
            return;
        }

        //https://cdwan.cn/api/goods/list?keyword=母亲&page=1&size=10&sort=default&order=desc&categoryId=0
        //keyword:关键字
        //page:页码,1开始
        //size:每页数量
        //sort:分类,每页传default
        //order:排序 desc降序 ,asce升序
        //categoryid:分类id,没有传0
        mPresenter.search(content);

        HistroyBean histroyBean = new HistroyBean(content, System.currentTimeMillis());
        mHistroyBeanDao.insertOrReplace(histroyBean);

        getHistoryFromDb();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @OnClick({R.id.tv_cancel, R.id.iv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                break;
            case R.id.iv_delete:
                break;
        }
    }
}
