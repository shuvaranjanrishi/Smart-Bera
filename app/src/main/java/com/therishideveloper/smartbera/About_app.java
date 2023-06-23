package com.therishideveloper.smartbera;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class About_app extends AppCompatActivity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        back=findViewById(R.id.back_about);
        back.setOnClickListener(view -> About_app.super.onBackPressed());
    }
}