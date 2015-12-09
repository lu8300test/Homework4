package com.hanssem.day4_work;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 20151047 on 2015-12-08.
 */
public class MenuActivity extends MainActivity {

    public static final int REQUEST_CODE_SUB_CM = 1002; // 고객관리
    public static final int REQUEST_CODE_SUB_SM = 1003; // 매출관리
    public static final int REQUEST_CODE_SUB_PM = 1004; // 제품관리

    Button cmBtn; //고객관리 버튼
    Button smBtn; //매출관리 버튼
    Button pmBtn; //제품관리 버튼
    Button LoginBtn; //로그인 버튼

    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.menu_activity);
    }

    // 고객관리
    public void onClicCM(View v){
        cmBtn=(Button)findViewById(R.id.cmBtn);

        Intent intent = new Intent(getApplicationContext(), Sub_cm.class);
        startActivityForResult(intent, REQUEST_CODE_SUB_CM);
    }

    // 매출관리
    public void onClicSM(View v){
        smBtn=(Button)findViewById(R.id.smBtn);

        Intent intent = new Intent(getApplicationContext(), Sub_sm.class);
        startActivityForResult(intent, REQUEST_CODE_SUB_SM);
    }

    // 상품관리
    public void onClicPM(View v){
        pmBtn=(Button)findViewById(R.id.pmBtn);

        Intent intent = new Intent(getApplicationContext(), Sub_pm.class);
        startActivityForResult(intent, REQUEST_CODE_SUB_PM);
    }

    // 로그인
    public void onClickLoginBtn(View v){
        LoginBtn=(Button)findViewById(R.id.loginBtn);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", "메뉴화면");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_SUB_CM) {
            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                Toast toast=Toast.makeText(getBaseContext(), "\""+ name+"\" 화면으로부터 보내온 응답 ", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else if(requestCode == REQUEST_CODE_SUB_SM){
            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                Toast toast=Toast.makeText(getBaseContext(), "\""+ name+"\" 화면으로부터 보내온 응답", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else if(requestCode == REQUEST_CODE_SUB_PM){
            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                Toast toast=Toast.makeText(getBaseContext(), "\""+ name+"\" 화면으로부터 보내온 응답", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
