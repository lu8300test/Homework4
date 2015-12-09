package com.example.user.day4_kangminkyoung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 20150092 on 2015-12-08.
 */
public class ProductsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
    }

    public void onButton6Clicked(View v){
        finish();
    }
}