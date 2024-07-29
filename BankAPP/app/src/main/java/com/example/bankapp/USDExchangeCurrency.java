package com.example.bankapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class USDExchangeCurrency extends AppCompatActivity {
    private String coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usdexchange_currency);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            String fruit = String.format(bundle.getString("COIN"));

            //set Name
            TextView title = (TextView) findViewById(R.id.title);
            Button tontdButton = (Button)findViewById(R.id.tontd);
            Button ntdtoButton = (Button)findViewById(R.id.ntdto);

            if(coin.equals("USD")){
                title.setText("美金換匯");
                tontdButton.setText("美金換新台幣");
                ntdtoButton.setText("新台幣換美金");
            }else {

            }
        }
    }
}