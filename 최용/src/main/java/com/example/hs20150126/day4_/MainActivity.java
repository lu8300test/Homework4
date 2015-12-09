package com.example.hs20150126.day4_;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    EditText editID;
    EditText editPW;
    public static final int REQUEST_CODE_Menu = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID = (EditText) findViewById(R.id.editID);
        editPW = (EditText) findViewById(R.id.editPW);
    }

    public void onButtonLoginClicked(View v) {

        String editIDv = editID.getText().toString();
        String editPWv = editPW.getText().toString();


        Intent intent = new Intent(getBaseContext(), MenuActivity.class);

        if (editIDv.equals("") || editPWv.equals("")) {
            Toast toast = Toast.makeText(this, "값을 입력하시오", Toast.LENGTH_LONG);
            toast.show();
        } else if(editIDv != "" && editPWv != ""){
            startActivityForResult(intent, REQUEST_CODE_Menu);
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
