package com.example.user.day4_kangminkyoung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText id;
    EditText password;

    public static final int REQUST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
    }

    public void onButton1Clicked(View v){
        if(id.getText().toString().length()==0||password.getText().toString().length()==0){
              Toast.makeText(this,"id와 비밀번호를 입력해주세요.",Toast.LENGTH_LONG).show();
        }else{
            Intent menu = new Intent(this,MenuActivity.class);
            startActivityForResult(menu, REQUST_CODE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUST_CODE){
            Toast.makeText(this,"로그아웃하였습니다.",Toast.LENGTH_LONG).show();
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
