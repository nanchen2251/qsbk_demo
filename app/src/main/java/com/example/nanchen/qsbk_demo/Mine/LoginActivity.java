package com.example.nanchen.qsbk_demo.Mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nanchen.qsbk_demo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button back,use_qq,use_wx,use_sina,login,forgot_pwd,regist;
    private EditText editText_account,editText_pwd;

    private void initBind(){
        back = (Button) findViewById(R.id.menu_back);
        back.setText("登录/注册");
        use_qq = (Button) findViewById(R.id.use_qq_login);
        use_wx = (Button) findViewById(R.id.use_wx_login);
        use_sina = (Button) findViewById(R.id.use_sina_login);
        login = (Button) findViewById(R.id.login);
        forgot_pwd = (Button) findViewById(R.id.forgot_pwd);
        regist = (Button) findViewById(R.id.regist);

        editText_account = (EditText) findViewById(R.id.edit_account);
        editText_pwd = (EditText) findViewById(R.id.edit_pwd);

        back.setOnClickListener(this);
        use_qq.setOnClickListener(this);
        use_wx.setOnClickListener(this);
        use_sina.setOnClickListener(this);
        login.setOnClickListener(this);
        forgot_pwd.setOnClickListener(this);
        regist.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initBind();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_back:
                LoginActivity.this.finish();
                break;
            case R.id.use_qq_login:
                Toast.makeText(LoginActivity.this,"你点击了使用qq登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.use_wx_login:
                Toast.makeText(this,"你点击了使用微信登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.use_sina_login:
                Toast.makeText(this,"你点击了使用微博登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login:
                Toast.makeText(this,"你点击了登录按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.forgot_pwd:
                Toast.makeText(this,"你点击了忘记密码按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.regist:
                Toast.makeText(this,"你点击了注册按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
