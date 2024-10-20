package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText result;
    Button btnAdd, btnSub, btnMul, btnDiv, btnSqrt, btnEqual, btnClear, btnBack, btnSignChange;
    Button[] numberButtons = new Button[10];
    float valueOne, valueTwo;
    boolean add, sub, mul, div, sqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnSqrt = findViewById(R.id.btnSqrt);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);
        btnSignChange = findViewById(R.id.btnSignChange);

        for (int i = 0; i < 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            numberButtons[i] = findViewById(resID);
            final int index = i;
            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result.append(String.valueOf(index));
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(result.getText().toString());
                add = true;
                result.setText("");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(result.getText().toString());
                sub = true;
                result.setText("");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(result.getText().toString());
                mul = true;
                result.setText("");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(result.getText().toString());
                div = true;
                result.setText("");
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(result.getText().toString());
                sqrt = true;
                result.setText("");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Float.parseFloat(result.getText().toString());

                if (add) {
                    result.setText(valueOne + valueTwo + "");
                    add = false;
                }

                if (sub) {
                    result.setText(valueOne - valueTwo + "");
                    sub = false;
                }

                if (mul) {
                    result.setText(valueOne * valueTwo + "");
                    mul = false;
                }

                if (div) {
                    result.setText(valueOne / valueTwo + "");
                    div = false;
                }

                if (sqrt) {
                    result.setText(Math.sqrt(valueOne) + "");
                    sqrt = false;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                if (currentText.length() > 0) {
                    result.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        btnSignChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentValue = Float.parseFloat(result.getText().toString());
                result.setText(String.valueOf(currentValue * -1));
            }
        });
    }
}
