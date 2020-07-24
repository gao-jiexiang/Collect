package com.example.collect.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collect.R;

import org.greenrobot.eventbus.EventBus;

public class ExitLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_login);
        initView();
    }

    private void initView() {
        mExit = (Button) findViewById(R.id.exit);
        mExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                // TODO 20/03/31
                EventBus.getDefault().post("未登录");
                finish();
                break;
            default:
                break;
        }
    }
}
