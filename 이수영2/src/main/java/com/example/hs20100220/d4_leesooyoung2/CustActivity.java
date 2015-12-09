package com.example.hs20100220.d4_leesooyoung2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


/**
 * 인텐트를 이용해 새로운 액티비티를 띄우고 다시 돌아오는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 */
public class CustActivity extends Activity {

    /**
     * 요청 코드 정의
     */
    public static final int RESPONSE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust);
    }

    public void onButton1Clicked(View v) {

        Intent resultIntent = new Intent();
        resultIntent.putExtra("message", "CustActivity is OK!");

        setResult(RESPONSE_CODE, resultIntent);
        finish();
    }
}