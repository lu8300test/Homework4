package com.busyo.yeonho.doltmission_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class prod extends ActionBarActivity {
    public static String page,inputid;

    public static int pagecode=0004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod);
        backPressCloseHandler = new BackPressCloseHandler(this);
        receiveintent();
        Button closebt = (Button)findViewById(R.id.close);
        closebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btclick();


            }
        });


    }
    public void btclick(){
        Intent menuintent = new Intent();//(getBaseContext(),menu.class);
        menuintent.putExtra("page", "상품관리화면");
        menuintent.putExtra("inputid", inputid);

        setResult(RESULT_OK, menuintent);

        finish();
    }

    public void receiveintent()
    {
        Intent receiveintent = getIntent();
        page = receiveintent.getStringExtra("page");
        inputid = receiveintent.getStringExtra("inputid");


        Toast mainpur = Toast.makeText(getApplicationContext(),"이전화면 : " +page+"\n"+"입력한 아이디 : "+inputid+"\n"
                +"입력한 암호 : 안알랴쥼",Toast.LENGTH_SHORT);
        mainpur.setGravity(Gravity.CENTER, 0, 0);
        mainpur.show();

    }
    private BackPressCloseHandler backPressCloseHandler; //뒤로가기 버튼
    @Override
    public void onBackPressed() {//물리적인 뒤로가기 눌렀을때를 호출
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    public class BackPressCloseHandler {  //물리적인 뒤로가기 눌렀을때

        private Activity activity;

        public BackPressCloseHandler(Activity context) {
            this.activity = context;
        }

        public void onBackPressed() {
            btclick();
        }
    }
}
