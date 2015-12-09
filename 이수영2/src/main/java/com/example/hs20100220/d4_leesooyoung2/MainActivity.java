package com.example.hs20100220.d4_leesooyoung2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * 인텐트를 이용해 새로운 액티비티를 띄우고 다시 돌아오는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 */
public class MainActivity extends Activity {

    public static final int REQUEST_CODE_LOGIN = 1000;

    EditText textLoginId;
    EditText textLoginName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLoginId = (EditText) findViewById(R.id.editText);
        textLoginName = (EditText) findViewById(R.id.editText2);

    }




    public void onButton1Clicked(View v) {

        if (textLoginId.getText().toString().equals("") || textLoginName.getText().toString().equals("")) {
            Toast toast = Toast.makeText(getBaseContext(), "로그인 ID 나 이름이 입력되지 않았습니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        // 인텐트 객체를 만드는 방법 #1

        // 인텐트 객체를 만듭니다.
        Intent intent = new Intent(getBaseContext(), MenuActivity.class);

        // 액티비티를 띄워주도록 startActivityForResult() 메소드를 호출합니다.
        startActivityForResult(intent, REQUEST_CODE_LOGIN);

    }


    /**
     * 새로운 액티비티에서 돌아올 때 자동 호출되는 메소드
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_LOGIN) {
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult() 메소드가 호출됨. 요청코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if (resultCode == RESULT_OK) {
                String name = intent.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_LONG);
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