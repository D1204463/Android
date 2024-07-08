package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Num1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void add(View view){
        EditText num1View = (EditText)findViewById(R.id.num1);
        EditText num2View = (EditText)findViewById(R.id.num2);
        TextView resultView = (TextView) findViewById(R.id.result);

        Double addResult = Double.parseDouble(num1View.getText().toString()) + Double.parseDouble(num2View.getText().toString());
        resultView.setText(String.valueOf(addResult));
    }
    public void cut(View view){
        EditText num1View = (EditText) findViewById(R.id.num1);
        EditText num2View = (EditText)findViewById(R.id.num2);
        TextView resultView = (TextView) findViewById(R.id.result);

        Double cutResult = Double.parseDouble(num1View.getText().toString()) - Double.parseDouble(num2View.getText().toString());
        resultView.setText(String.valueOf(cutResult));

    }
    public void multiply(View view){
        EditText num1View = (EditText) findViewById(R.id.num1);
        EditText num2View = (EditText)findViewById(R.id.num2);
        TextView resultView = (TextView) findViewById(R.id.result);

        Double multiplyResult = Double.parseDouble(num1View.getText().toString()) * Double.parseDouble(num2View.getText().toString());
        resultView.setText(String.valueOf(multiplyResult));

    }
    public void divide(View view){
        EditText num1View = (EditText) findViewById(R.id.num1);
        EditText num2View = (EditText)findViewById(R.id.num2);
        TextView resultView = (TextView) findViewById(R.id.result);
        if( Double.parseDouble(num2View.getText().toString()) == 0){
            resultView.setText("數字不可為0");
        }
        else{
            double divideResult = Double.parseDouble(num1View.getText().toString()) / Double.parseDouble(num2View.getText().toString());
            resultView.setText(String.valueOf(divideResult));
        }
    }
}