package com.example.exampractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Alert!").setMessage("Do you really want to continue?");
        builder.setCancelable(true);

        builder.setPositiveButton("Ofcourse!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("No way!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog=builder.create();
        builder.show();

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Add button listeners
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }

    // Method to handle calculations
    private void calculate(char operator) {
        String num1Str = num1.getText().toString();
        String num2Str = num2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(num1Str);
        double number2 = Double.parseDouble(num2Str);
        double resultValue = 0;

        switch (operator) {
            case '+':
                resultValue = number1 + number2;
                break;
            case '-':
                resultValue = number1 - number2;
                break;
            case '*':
                resultValue = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    resultValue = number1 / number2;
                } else {
                    Toast.makeText(this,"Division by zero is not possible",Toast.LENGTH_SHORT).show();
                    //result.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        result.setText("Result: " + resultValue);
    }
}
