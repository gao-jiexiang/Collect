package com.example.collect.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collect.R;
import com.example.collect.base.BaseActivity;
import com.example.collect.base.BaseApp;
import com.example.collect.base.Constants;
import com.example.collect.bean.LoginBean;
import com.example.collect.presenter.LoginPresenter;
import com.example.collect.ui.register.RegistActivity;
import com.example.collect.util.ToastUtil;
import com.example.collect.view.LoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.Nullable;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edit_nickname)
    EditText mEditNickname;
    @BindView(R.id.edit_pw)
    EditText mEditPw;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_register)
    TextView mTvRegister;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.btn_login, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_register:
                go2Register();
                break;
        }
    }

    //注册
    private void go2Register() {
        Intent intent = new Intent(this, RegistActivity.class);
        startActivityForResult(intent,200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200&&resultCode==300){
            mEditNickname.setText(data.getStringExtra(Constants.USERNAME));
        }
    }

    //登录
    private void login() {
        String name = mEditNickname.getText().toString().trim();
        String pw = mEditPw.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pw)) {
            mPresenter.login(name,pw);
        }else {
            Toast.makeText(this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if(msg.equals("登录成功")) {
            finish();
        }
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        showToast("登录成功");
        finish();
        //登录成功需要修改application中的状态
        BaseApp.isLogin = true;
        //通知mefragment设置用户名称,并且点击的时候不能再进入登录页面了
        EventBus.getDefault().post(loginBean);
    }

    @Subscribe
    public void receive(LoginBean baen){
        String nickname = baen.getData().getUserInfo().getNickname();
    }
}
