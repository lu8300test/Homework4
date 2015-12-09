package com.example.user.day4_kangminkyoung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 20150092 on 2015-12-08.
 */
public class MenuActivity extends Activity{

    Intent select;
    public static int REQUST_CODE = 1001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void onButton2Clicked(View v){
        REQUST_CODE = 1002;
        select = new Intent(this,CustomerActivity.class);
        startActivityForResult(select, REQUST_CODE);
    }

    public void onButton3Clicked(View v){
        REQUST_CODE = 1003;
        select = new Intent(this,SalesActivity.class);
        startActivityForResult(select, REQUST_CODE);
    }

    public void onButton4Clicked(View v){
        REQUST_CODE = 1004;
        select = new Intent(this,ProductsActivity.class);
        startActivityForResult(select, REQUST_CODE);
    }

    public void onButton5Clicked(View v){
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002) {
            Toast.makeText(this, "고객 관리 종료", Toast.LENGTH_LONG).show();
        }
        else if (requestCode == 1003) {
            Toast.makeText(this, "매출 관리 종료", Toast.LENGTH_LONG).show();
        }
        else if (requestCode == 1004) {
            Toast.makeText(this, "상품 관리 종료", Toast.LENGTH_LONG).show();
        }
    }
}
