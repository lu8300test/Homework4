package com.example.day4_kimminkyuhw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ANOTHER1 = 1001;
    public static final int REQUEST_CODE_ANOTHER2 = 1002;
    public static final int REQUEST_CODE_ANOTHER3 = 1003;

    Button button2, button3, button4, button6;
    String menu2, menu3, menu4;

    String rtMenu="";
    Intent intent1, intent2, intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        //로그인화면으로 돌아가는 버튼
        button6 = (Button) findViewById(R.id.button6);


        menu2 = button2.getText().toString();
        menu3 = button3.getText().toString();
        menu4 = button4.getText().toString();

        //Log.d("Menuname", menu1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = new Intent(getBaseContext(), SubActivity.class);
                intent1.putExtra("Name", menu2);

                startActivityForResult(intent1,REQUEST_CODE_ANOTHER1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(getBaseContext(), SubActivity.class);
                intent2.putExtra("Name", menu3);

                startActivityForResult(intent2,REQUEST_CODE_ANOTHER2);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3 = new Intent(getBaseContext(), SubActivity.class);
                intent3.putExtra("Name", menu4);

                startActivityForResult(intent3,REQUEST_CODE_ANOTHER3);
            }
        });
        //receiveIntent();
        //로그인화면으로 돌아가는 버튼클릭
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MenuActivity.class);

                intent.putExtra("menuName", "메뉴");
                //startActivity(intent);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_ANOTHER1:
                if(resultCode == RESULT_OK){
                    rtMenu = data.getStringExtra("menuName");
                    Toast.makeText(getApplicationContext(),rtMenu + "에서 돌아왔습니다.",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_ANOTHER2:
                if(resultCode == RESULT_OK){
                    rtMenu = data.getStringExtra("menuName");
                    Toast.makeText(getApplicationContext(),rtMenu + "에서 돌아왔습니다.",Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_ANOTHER3:
                if(resultCode == RESULT_OK){
                    rtMenu = data.getStringExtra("menuName");
                    Toast.makeText(getApplicationContext(),rtMenu + "에서 돌아왔습니다.",Toast.LENGTH_SHORT).show();
                }
                break;
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
