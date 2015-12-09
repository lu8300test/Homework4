package com.example.day4_kimminkyuhw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ANOTHER = 1000;
    Button button1;
    EditText id, pw;
    String rtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);

        id = (EditText) findViewById(R.id.editID);
        pw = (EditText) findViewById(R.id.editPW);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!id.getText().toString().equals("20140302")){
                    Toast.makeText(getApplicationContext(), "ID가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }else if(!pw.getText().toString().equals("a")){
                    Toast.makeText(getApplicationContext(), "PW가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }else if(id.getText().toString().equals("20140302")&&pw.getText().toString().equals("a")){
                    Toast.makeText(getApplicationContext(), "로그인되었습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), MenuActivity.class);

                    intent.putExtra("menuName", "Login");

                    //startActivity(intent);
                    startActivityForResult(intent, REQUEST_CODE_ANOTHER);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            rtMenu = data.getStringExtra("menuName");
            Toast.makeText(getApplicationContext(),rtMenu + "에서 돌아왔습니다.",Toast.LENGTH_SHORT).show();
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
