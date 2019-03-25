package com.watermelon.login_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    CheckBox cb_remenber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        cb_remenber = findViewById(R.id.cb_remember);

        /**
         * 从文件中读取用户信息
         */
        Map<String, String> user = UserInfoUtils.readUserInfo(MainActivity.this);
        if(user!=null)
        {
            et_username.setText(user.get("username"));
            et_password.setText(user.get("password"));
        }
    }

    public void handleLoginButton(View view) {

        if (TextUtils.isEmpty(et_username.getText().toString())) {
            Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(et_password.getText().toString())) {
            Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
            return;
        }

        if (cb_remenber.isChecked()) {
            try {
                UserInfoUtils.writeUserInfo(MainActivity.this,et_username.getText().toString(), et_password.getText().toString());
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "记住密码失败", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(MainActivity.this, "记住密码成功", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(MainActivity.this, "不需要记住密码", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(MainActivity.this, "正在进行登录操作", Toast.LENGTH_LONG).show();
    }
}
