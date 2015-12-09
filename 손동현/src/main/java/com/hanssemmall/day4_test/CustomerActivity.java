package com.hanssemmall.day4_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CustomerActivity extends ActionBarActivity {
    public static final int RESPONSE_CODE_OK = 200;
    public static final int RESPONSE_CODE_ERROR = 400;

    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(RESPONSE_CODE_OK, resultIntent);
                finish();
            }
        });

    }

}
