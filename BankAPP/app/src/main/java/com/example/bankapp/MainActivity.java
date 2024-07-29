package com.example.bankapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private double amount;
    private ActivityResultLauncher<Intent> intentActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        intentActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult o){
                        //這裡寫另一個Activity回傳後，獲取資料並處理的地方
                        if (o.getData() != null && o.getResultCode() == Activity.RESULT_OK){
                            amount = o.getData().getDoubleExtra("AMOUNT",0);
                            String action = o.getData().getStringExtra("ACTION");
                            TextView tv_ntdBalance = (TextView) findViewById(R.id.NTDbalance);
                            TextView tv_result = (TextView) findViewById(R.id.resulit);
                            double ntd_balance = Double.parseDouble(tv_ntdBalance.getText().toString());

                            tv_result.setText("交易成功");
                            tv_result.setTextColor(Color.parseColor("#33AA33"));


                            if (action.equals("deposit")){
                                tv_ntdBalance.setText(String.valueOf(amount + ntd_balance));
                            }else if(action.equals("withdraw")){
                                if (ntd_balance >= amount){
                                    tv_ntdBalance.setText(String.valueOf(ntd_balance - amount));
                                }else {
                                    tv_result.setText("餘額不足，交易失敗！");
                                    tv_result.setTextColor(Color.parseColor("#AA3333"));
                                }
                            } else if (action.equals("tontd")) {
                                double rate = o.getData().getDoubleExtra("RATE",0);
                                TextView tv usdbalance = (TextView)findViewById(R.id.usdbalance);
                                double usdBalance = Double.parseDouble(tv_usdbalance.getText.toString());

                                if(usdBalance >= amount){
                                    double r = (usdBalance - amount) * rate;
                                    tv_ntdBalance.setText(String.valueOf(ntd_balance + r));
                                }else {
                                    tv_result.setText("餘額不足，交易失敗！");
                                    tv_result.setTextColor(Color.parseColor("#AA3333"));
                                }
                            }
                        }
                    }
                }
        );
    }
    public void GotoNTD(View view){
        Intent i = new Intent(this, NTDActivity.class);

        intentActivityResultLauncher.launch(i);

    }

    public void Exchange(View view){
        String coin;
        if (view.getId() == R.id.usdButton){
            coin = "USD";
        }else {
            coin = "JPY";
        }

        Intent intent = new Intent(this, USDExchangeCurrency.class);

        //設定一個bundle來放資料
        Bundle bundle = new Bundle();
        bundle.putString("COIN",coin);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}