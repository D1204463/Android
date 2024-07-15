package com.example.activitypractice2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class fruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            String fruit = String.format(bundle.getString("FRUIT"));
            TextView name = (TextView) findViewById(R.id.Name);
            name.setText(fruit);

            ImageView img = (ImageView) findViewById(R.id.image);
            String filename = fruit.toLowerCase();
            int imgId = getResources().getIdentifier(filename,"drawable",getPackageName());
            Drawable drawableId = ContextCompat.getDrawable(this,imgId);
            img.setImageDrawable(drawableId);
        }
    }

    public void CloseActivity(View view){
        finish();
    }
}