package com.busyo.yeonho.doltmission_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu extends ActionBarActivity {

    public static final int pagecode = 0002;
    public static String page, inputid;
    private BackPressCloseHandler backPressCloseHandler; //뒤로가기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        receiveintent();
        backPressCloseHandler = new BackPressCloseHandler(this);

        Button custbt = (Button) findViewById(R.id.cust);
        Button salebt = (Button) findViewById(R.id.sale);
        Button prodbt = (Button) findViewById(R.id.prod);
        Button logbt = (Button) findViewById(R.id.log);
        custbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent custintent = new Intent(getBaseContext(), cust.class);
                custintent.putExtra("page", "메뉴화면");
                custintent.putExtra("inputid", inputid);

                // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
                startActivityForResult(custintent, pagecode);

            }
        });
        salebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saleintent = new Intent(getBaseContext(), sale.class);
                saleintent.putExtra("page", "메뉴화면");
                saleintent.putExtra("inputid", inputid);

                // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
                startActivityForResult(saleintent, pagecode);

            }
        });
        prodbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prodintent = new Intent(getBaseContext(), prod.class);
                prodintent.putExtra("page", "메뉴화면");
                prodintent.putExtra("inputid", inputid);

                // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
                startActivityForResult(prodintent, pagecode);

            }
        });

        logbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btclick();


            }
        });


    }

    public void btclick() {
        Intent menuintent = new Intent();//(getBaseContext(),menu.class);
        menuintent.putExtra("page", "메뉴화면");
        menuintent.putExtra("inputid", inputid);

        setResult(RESULT_OK, menuintent);

        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // 전달받은 인텐트를 처리processIntent();합니다.

        super.onNewIntent(intent);
        receiveintent();////////////정연호 추가
    }

    public void receiveintent() {
        Intent receiveintent = getIntent();
        page = receiveintent.getStringExtra("page");
        inputid = receiveintent.getStringExtra("inputid");

        Toast mainpur = Toast.makeText(getApplicationContext(), "이전화면 : " + page + "\n" + "입력한 아이디 : " + inputid + "\n" + "입력한 암호 : 안알랴쥼", Toast.LENGTH_SHORT);
        mainpur.setGravity(Gravity.CENTER, 0, 0);
        mainpur.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pagecode && resultCode == RESULT_OK) {
            Toast.makeText(this, "이전 화면 : " + data.getStringExtra("page") + "\n" +
                    "입력한 아이디 : " + data.getStringExtra("inputid") + "\n" +
                    "페이지코드 : " + requestCode + "\n 결과코드 : " + resultCode, Toast.LENGTH_SHORT).show();
        }
    }

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
