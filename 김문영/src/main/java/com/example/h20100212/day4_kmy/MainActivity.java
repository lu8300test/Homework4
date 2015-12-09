package com.example.h20100212.day4_kmy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    TextView textView1;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setContentView(R.layout.another);
        //Toast.makeText(this, "onCreate() 호출됨", Toast.LENGTH_LONG).show();

        textView1 = (TextView) findViewById(R.id.textView1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {
        if(editText1.getText().toString().trim().equals(""))
        {
            Toast.makeText(this, "ID 없음", Toast.LENGTH_LONG).show();
        }
        else if(editText2.getText().toString().trim().equals(""))
        {
            Toast.makeText(this, "PW 없음", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent menu_Intent = new Intent(this, MenuActivity.class);
            startActivity(menu_Intent);
        }
        /*
        String data = editText1.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
        startActivity(intent);
        */

        /*
        Intent myIntent = new Intent(this, MyService.class);
        startService(myIntent);
        */
    }

    @Override
    protected void onDestroy() {
        //Toast.makeText(this, "onDestroy() 호출됨", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }

    @Override
    protected void onPause() {
        //Toast.makeText(this, "onPause() 호출됨", Toast.LENGTH_LONG).show();

        //saveCurrentState();

        super.onPause();
    }

    @Override
    protected void onStart() {
        //Toast.makeText(this, "onStart() 호출됨", Toast.LENGTH_LONG).show();

        super.onStart();
    }

    @Override
    protected void onRestart() {
        //Toast.makeText(this, "onRestart() 호출됨", Toast.LENGTH_LONG).show();

        super.onRestart();
    }

    @Override
    protected void onStop() {
        //Toast.makeText(this, "onStop() 호출됨", Toast.LENGTH_LONG).show();

        super.onStop();
    }

    @Override
    protected void onResume() {
        //Toast.makeText(this, "onResume() 호출됨", Toast.LENGTH_LONG).show();

        //restoreFromSaveState();

        super.onResume();
    }

}
