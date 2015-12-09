package com.example.calpractice;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    public float m1 = 0, m2 = 0; // 앞뒤 숫자
    public float result; // 결과
    public int intValue;
    TextView mTextiew_Result; // 결과값 표시

    String mOP; // 연산자 표시
    Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00; // 버튼
    Button btnDiv, btnMul, btnPlus, btnMinus, btnClear, btnDel, btnResult, btnPoint; // 연산자 및 기호

    ArrayAdapter<String> adapter; // 리스트뷰를 위한 어댑터 생성

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                // 숫자 버튼 부분
                case R.id.Btn01:
                case R.id.Btn02:
                case R.id.Btn03:
                case R.id.Btn04:
                case R.id.Btn05:
                case R.id.Btn06:
                case R.id.Btn07:
                case R.id.Btn08:
                case R.id.Btn09:
                case R.id.Btn00:
                    Button temp = (Button) v;
                    mTextiew_Result.append(temp.getText());
                    break;

                // 연산기호 버튼
                case R.id.BtnPlus:
                case R.id.BtnMinus:
                case R.id.BtnDiv:
                case R.id.BtnMul:

                    if (!mTextiew_Result.getText().equals("")) {
                        Button temp2 = (Button) v;
                        onCal(temp2.getText() + "");
                    }
                    break;

                // All Clear Button
                case R.id.BtnClear:
                    mTextiew_Result.setText("");
                    mOP = "";
                    m1 = 0;
                    m2 = 0;
                    break;

                // Delete 1 space
                case R.id.BtnDel:
                    Editable edit = (Editable) mTextiew_Result.getText();
                    int st = edit.length();
                    if (st > 1) {
                        edit.delete(st - 1, st);
                        mTextiew_Result.setText(edit);
                    } else if (st <= 1) {
                        mTextiew_Result.setText("");
                    }
                    break;

                // '=' 결과 출력 버튼
                case R.id.BtnResult:
                    if (mOP.toString().equals("")) {
                        mTextiew_Result.setText("");
                        m1 = 0;
                        m2 = 0;
                        break;
                    } else {
                        m2 = 0;
                        if (!(mTextiew_Result.getText().toString().equals(""))) {
                            m2 = Float.parseFloat(mTextiew_Result.getText().toString());
                        }
                        if (mOP.equals("+")) {
                            result = m1 + m2;
                        } else if (mOP.equals("-")) {
                            result = m1 - m2;
                        } else if (mOP.equals("÷")) {
                            result = m1 / m2;
                        } else if (mOP.equals("×")) {
                            result = m1 * m2;
                        }
                        intValue = (int) result;
                        if (result == intValue) {
                            mTextiew_Result.setText(String.valueOf(intValue));
                        } else {
                            mTextiew_Result.setText(String.valueOf(result));
                        }
                        m1 = 0;
                        m2 = 0;
                        mOP = "";

                        if (!mTextiew_Result.getText().toString().equals("")) {
                            m1 = Integer.parseInt(mTextiew_Result.getText().toString());
                        } else {
                            m1 = 0;
                        }
                        adapter.add(intValue + ""); // add 하여 리스트뷰에 결과값 추가

                        break;
                    }
            } // end of switch
        } // end of onClick
    }; // end of mClickListener

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 누적값 배열 - 리스트 뷰
        ListView lv = (ListView) findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);

        // 레이아웃 불러오기
        mTextiew_Result = (TextView) findViewById(R.id.textView01);

        findViewById(R.id.Btn01).setOnClickListener(mClickListener);
        findViewById(R.id.Btn02).setOnClickListener(mClickListener);
        findViewById(R.id.Btn03).setOnClickListener(mClickListener);
        findViewById(R.id.Btn04).setOnClickListener(mClickListener);
        findViewById(R.id.Btn05).setOnClickListener(mClickListener);
        findViewById(R.id.Btn06).setOnClickListener(mClickListener);
        findViewById(R.id.Btn07).setOnClickListener(mClickListener);
        findViewById(R.id.Btn08).setOnClickListener(mClickListener);
        findViewById(R.id.Btn09).setOnClickListener(mClickListener);
        findViewById(R.id.Btn00).setOnClickListener(mClickListener);

        findViewById(R.id.BtnClear).setOnClickListener(mClickListener);
        findViewById(R.id.BtnDel).setOnClickListener(mClickListener);
        findViewById(R.id.BtnResult).setOnClickListener(mClickListener);
        findViewById(R.id.BtnDiv).setOnClickListener(mClickListener);
        findViewById(R.id.BtnMul).setOnClickListener(mClickListener);
        findViewById(R.id.BtnPlus).setOnClickListener(mClickListener);
        findViewById(R.id.BtnMinus).setOnClickListener(mClickListener);
    }

    public void onCal(String calType) {
        mOP = calType;
        if (m1 != 0 && !(calType.equals(""))) {
            m2 = Float.parseFloat(mTextiew_Result.getText().toString());
            if (calType.equals("+")) {
                result = m1 + m2;
            } else if (calType.equals("-")) {
                result = m1 - m2;
            } else if (calType.equals("÷")) {
                result = m1 / m2;
            } else if (calType.equals("×")) {
                result = m1 * m2;
            }
            intValue = (int) result;
            mTextiew_Result.setText(String.valueOf(result));
        }

        try {
            m1 = Float.parseFloat(mTextiew_Result.getText().toString());
        } catch (NumberFormatException ex) {
            m1 = 0;
        }

        if (!mTextiew_Result.getText().toString().equals("")) {
            m1 = Integer.parseInt(mTextiew_Result.getText().toString());
        } else {
            m1 = 0;
        }

        mTextiew_Result.setText("");
    }

} // end of class