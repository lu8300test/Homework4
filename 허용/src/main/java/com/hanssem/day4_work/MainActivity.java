package com.hanssem.day4_work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 1001; //메뉴화면
    EditText id;
    EditText pw;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* 로그인 버튼 눌렀을 때 id, pw값이 없으면 "아이디 또는 비밀번호를 입력해주세요"
    *  비밀번호 4자리 미만 입력시 "비밀번호 4자리를 입력해 주세요"*/
    public void onClickLogin(View v) {
        id = (EditText) findViewById(R.id.editTextId);
        pw = (EditText) findViewById(R.id.editTextPw);
        login_btn = (Button) findViewById(R.id.loginBtn);

        if (id.getText().length() == 0 || pw.getText().length() == 0) {
            Toast.makeText(this, "아이디 또는 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else if (pw.getText().length() < 4) {
            Toast.makeText(this, "비밀번호 4자리를 입력해 주세요", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, REQUEST_CODE_MENU);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_MENU) {

            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                Toast toast = Toast.makeText(getBaseContext(), "\"" + name + "\" 화면으로부터 보내온 응답", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}