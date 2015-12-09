package com.example.hs20150126.day4_;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {

    public static final int REQUEST_CODE_cut = 2001;
    public static final int REQUEST_CODE_sal = 2002;
    public static final int REQUEST_CODE_pro = 2003;
    public static final int REQUEST_CODE_Main = 2004;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getBaseContext(), cutmngActivity.class);
        startActivityForResult(intent, REQUEST_CODE_cut);

    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(getBaseContext(), salmngActivity.class);
        startActivityForResult(intent, REQUEST_CODE_sal);

    }

    public void onButtonProductClicked(View v) {
        Intent intent = new Intent(getBaseContext(), promngActivity.class);
        startActivityForResult(intent, REQUEST_CODE_pro);
    }

    public void onButton4Clicked(View v) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivityForResult(intent, REQUEST_CODE_Main);
        Toast toast = Toast.makeText(this, "로그인", Toast.LENGTH_LONG);
        toast.show();
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
