package com.example.hs20100220.d4_leesooyoung2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


/**
 * 인텐트를 이용해 새로운 액티비티를 띄우고 다시 돌아오는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 */
public class MenuActivity extends Activity {

    /**
     * 요청 코드 정의
     */
    public static final int REQUEST_CODE_CUST = 1001;
    public static final int REQUEST_CODE_SALE = 1002;
    public static final int REQUEST_CODE_PROD = 1003;

    public static final int RESULT_OK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButton1Clicked(View v) {
        // 인텐트 객체를 만드는 방법 #1

        // 인텐트 객체를 만듭니다.
        Intent intent = new Intent(getBaseContext(), CustActivity.class);

        // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
        startActivityForResult(intent, REQUEST_CODE_CUST);
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(getBaseContext(), SaleActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SALE);

    }

    public void onButton3Clicked(View v) {

        Intent intent = new Intent(getBaseContext(), ProdActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PROD);

    }

    public void onButton4Clicked(View v) {

        int RESPONSE_CODE = 222;
        Intent resultIntent = new Intent();
        resultIntent.putExtra("message", "MenuActivity is OK!");

        setResult(RESPONSE_CODE, resultIntent);
        finish();

    }

    /**
     * 새로운 액티비티에서 돌아올 때 자동 호출되는 메소드
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_CUST) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult() 메소드가 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if (resultCode == RESULT_OK) {
                String message = intent.getExtras().getString("message");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }
        else if (requestCode == REQUEST_CODE_SALE) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult() 메소드가 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if (resultCode == RESULT_OK) {
                String message = intent.getExtras().getString("message");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }
        else if (requestCode == REQUEST_CODE_PROD) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult() 메소드가 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if (resultCode == RESULT_OK) {
                String message = intent.getExtras().getString("message");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
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
}