package com.hanssem.day4_work;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 20151047 on 2015-12-08.
 */
public class Sub_pm extends MenuActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_pm_menu);

        Button closeBtn=(Button)findViewById(R.id.closePMBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", "상품관리");

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
