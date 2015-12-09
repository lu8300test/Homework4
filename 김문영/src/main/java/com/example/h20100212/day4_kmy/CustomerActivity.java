package com.example.h20100212.day4_kmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 20100212 on 2015-12-08.
 */
public class CustomerActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    public void onBtnCloseCustomer(View v){
        //Toast.makeText(this, "2", Toast.LENGTH_LONG).show();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("res","고객관리");

        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
