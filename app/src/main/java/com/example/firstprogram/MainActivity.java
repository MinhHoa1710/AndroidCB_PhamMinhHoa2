package com.example.firstprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnTimesSign, btnDivision, btnModulo, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        innitControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void innitControl() {
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnTimesSign = findViewById(R.id.btnTimesSign);
        btnDivision = findViewById(R.id.btnDivision);
        btnModulo = findViewById(R.id.btnModulo);
        btnReset = findViewById(R.id.btnReset);

        // Xử lý sự kiện cho các nút

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("-");
            }
        });
        btnTimesSign.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("*");
            }
        }));
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("/");
            }
        });
        btnModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("%");
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation("Reset");
            }
        });

    }
        private void performOperation(String operator) {
            try {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = 0;
                switch (operator) {
                    case "+":
                        result = x + y;
                        break;
                    case "-":
                        result = x-y;
                        break;
                    case "*":
                        result =x*y;
                        break;
                    case "/":
                        if(y!=0)
                        {
                            result =x/y;
                        }
                        else {txtResult.setText("Y phai khac 0");
                        return;
                        }
                        break;
                    case "%":
                        if (y!=0){
                            result =x%y;
                        }else {
                            txtResult.setText("Y phai khac 0");
                            return;
                        }
                        break;
                    case"Reset":
                        txtX.setText("");
                        txtY.setText("");
                        txtResult.setText("");
                        break;
                    default:
                        return;
                }
                txtResult.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                txtResult.setText("Vui lòng nhập số");

                }
    }
}