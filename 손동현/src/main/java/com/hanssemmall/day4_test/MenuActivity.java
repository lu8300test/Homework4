package com.hanssemmall.day4_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {
    // public static final int RESPONSE_CODE_OK = 200;
    public static final int REQUEST_CODE_CUSTOMER = 2001;
    public static final int REQUEST_CODE_SALES = 2002;
    public static final int REQUEST_CODE_PRODUCT = 2003;

    Button Btn_C; // 고객
    Button Btn_S; // 매출
    Button Btn_P; // 제품
    Button Btn_log; //로그인

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

        public void btn_C(View v) {
            Btn_C = (Button) findViewById(R.id.Button_Customer);

            Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
            startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
        }


    public void btn_S(View v) {
        Btn_S = (Button) findViewById(R.id.Button_Sales);

        Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SALES);
    }

    public void btn_P(View v) {
        Btn_P = (Button) findViewById(R.id.Button_Product);

        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PRODUCT);
    }

    public void btn_log(View v){
        Btn_log=(Button)findViewById(R.id.Button_Back2Login);
        Btn_log.setOnClickListener(new View.OnClickListener() {
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

        if (requestCode == REQUEST_CODE_CUSTOMER) {
            Toast toast = Toast.makeText(getBaseContext(), "요청코드 : " + requestCode + "결과코드 : " + resultCode, Toast.LENGTH_SHORT);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT);
                toast.show();
            }
        } else if (requestCode == REQUEST_CODE_SALES) {
            Toast toast = Toast.makeText(getBaseContext(), "요청코드 : " + requestCode + "결과코드 : " + resultCode, Toast.LENGTH_SHORT);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT);
                toast.show();
            }
        } else if (requestCode == REQUEST_CODE_PRODUCT) {
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

