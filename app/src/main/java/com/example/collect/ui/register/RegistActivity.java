package com.example.collect.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.Constants;
import com.example.collect.presenter.RegistPresenter;
import com.example.collect.view.RegistView;

public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistView, View.OnClickListener {

    private EditText mNameRegist;
    private EditText mPassRegist;
    private EditText mSurePassRegist;
    private Button mRegist;
    private String name;

    @Override
    protected RegistPresenter initPresenter() {
        return new RegistPresenter();
    }

    @Override
    public void initView() {
        mNameRegist = (EditText) findViewById(R.id.regist_name);
        mPassRegist = (EditText) findViewById(R.id.regist_pass);
        mSurePassRegist = (EditText) findViewById(R.id.regist_sure_pass);
        mRegist = (Button) findViewById(R.id.regist);
        mRegist.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist:
                // TODO 20/03/31
                regist();
                break;
            default:
                break;
        }
    }

    private void regist() {
        name = mNameRegist.getText().toString().trim();
        String pass = mPassRegist.getText().toString().trim();
        String sure_pass = mSurePassRegist.getText().toString().trim();
        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pass)&&!TextUtils.isEmpty(sure_pass)){
            if(pass.equals(sure_pass)){
                mPresenter.getData(name,pass);
            }else {
                Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if(msg.equals("注册成功")){
            Intent intent = new Intent();
            intent.putExtra(Constants.USERNAME,name);
            setResult(300,intent);
            finish();
        }
    }
}
