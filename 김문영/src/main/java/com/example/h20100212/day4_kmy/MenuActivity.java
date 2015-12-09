package com.example.h20100212.day4_kmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 20100212 on 2015-12-08.
 */
public class MenuActivity extends Activity{

    public static final int REQUEST_CODE_CUSTOMER = 1001;
    public static final int REQUEST_CODE_SALES = 1002;
    public static final int REQUEST_CODE_PRODUCT = 1003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButtonCustomerClicked(View v) {
        Intent customer_Intent = new Intent(this, CustomerActivity.class);
        startActivityForResult(customer_Intent, REQUEST_CODE_CUSTOMER);
    }

    public void onButtonSalesClicked(View v) {
        Toast.makeText(this, "2", Toast.LENGTH_LONG).show();
    }

    public void onButtonProductClicked(View v) {
        Toast.makeText(this, "3", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == REQUEST_CODE_CUSTOMER){
            if(resultCode == RESULT_OK){
                String res = intent.getExtras().getString("res");
                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            }
        }
    }
}
