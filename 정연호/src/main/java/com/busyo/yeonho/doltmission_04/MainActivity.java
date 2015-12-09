package com.busyo.yeonho.doltmission_04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public static int pagecode = 0001;
    static String id = "20090121";
    static String pw = "20090121";
    private BackPressCloseHandler backPressCloseHandler; //뒤로가기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backPressCloseHandler = new BackPressCloseHandler(this);
        final TextView idtv = (TextView) findViewById(R.id.editid);
        final TextView pwtv = (TextView) findViewById(R.id.editpw);
        Button loginbt = (Button) findViewById(R.id.loginbutton);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (idtv.getText().toString().isEmpty()) {
                    Toast idto = Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT);
                    idto.setGravity(Gravity.CENTER, 0, 0);
                    idto.show();
                } else if (!idtv.getText().toString().equals(id)) {
                    Toast idto = Toast.makeText(getApplicationContext(), "아이디가 " + idtv.getText() + "이(가) 아닙니다.", Toast.LENGTH_SHORT);
                    idto.setGravity(Gravity.CENTER, 0, 0);
                    idto.show();

                } else if (pwtv.getText().toString().isEmpty()) {
                    Toast idto = Toast.makeText(getApplicationContext(), "암호를 입력하세요.", Toast.LENGTH_SHORT);
                    idto.setGravity(Gravity.CENTER, 0, 0);
                    idto.show();
                } else if (!pwtv.getText().toString().equals(pw)) {
                    Toast idto = Toast.makeText(getApplicationContext(), "암호가 틀렸습니다.", Toast.LENGTH_SHORT);
                    idto.setGravity(Gravity.CENTER, 0, 0);
                    idto.show();
                } else {
                    Toast idto = Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT);
                    idto.setGravity(Gravity.CENTER, 0, 0);
                    //idto.show();

                    Intent menuintent = new Intent(getBaseContext(), menu.class);
                    menuintent.putExtra("page", "로그인화면");
                    menuintent.putExtra("inputid", idtv.getText().toString());
                    menuintent.putExtra("inputpw", pwtv.getText().toString());
                    // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
                    startActivityForResult(menuintent, pagecode);



                }

            }


        });

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {//물리적인 뒤로가기 눌렀을때를 호출
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    public class BackPressCloseHandler {  //물리적인 뒤로가기 눌렀을때

        private long backKeyPressedTime = 0;
        private Toast toast;

        private Activity activity;

        public BackPressCloseHandler(Activity context) {
            this.activity = context;
        }

        public void onBackPressed() {
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                showGuide();
                return;
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                activity.finish();
                toast.cancel();
            }
        }

        public void showGuide() {
            toast = Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            //toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0,0);//토스트 표시의 위치변경
            toast.show();
        }
    }

}
