package com.hanssemmall.day4_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_MENU = 1001;

    EditText nInput;
    EditText pwInput;
    Button log_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickLogin(View v) {
        nInput = (EditText) findViewById(R.id.nameInput);
        pwInput = (EditText) findViewById(R.id.passwordInput);
        log_btn = (Button) findViewById(R.id.loginButton);

        if (nInput.getText().length() == 0 || pwInput.getText().length() == 0) {

            Toast.makeText(this, "ID 혹은 PW를 입력하세요!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, REQUEST_CODE_MENU);
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast toast = Toast.makeText(getBaseContext(), "요청코드 : " + requestCode + "결과코드 : " + resultCode, Toast.LENGTH_SHORT);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}