package com.example.day4_kimminkyuhw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView    textView;
    Button button5;
    String menuName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        button5 = (Button) findViewById(R.id.button5);
        textView = (TextView) findViewById(R.id.textView);

        receiveIntent();
        //menuName = textView.getText().toString();
        textView.setText(menuName);
        //Log.d("menuName", menuName);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MenuActivity.class);

                intent.putExtra("menuName", menuName);
                //startActivity(intent);
                setResult(RESULT_OK, intent);

                finish();
            }
        });


    }

    private void receiveIntent(){
        Intent receiveIntent = getIntent();
        menuName = receiveIntent.getStringExtra("Name");

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
