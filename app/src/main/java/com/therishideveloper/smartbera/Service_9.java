package com.therishideveloper.smartbera;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Service_9 extends AppCompatActivity {

//    AdView mAdView;
//    InterstitialAd mInterstitialAd;
    LottieAnimationView journalist1, journalist2, journalist3, journalist4, journalist5;
    ImageView back;
    public String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service9);

        journalist1 = findViewById(R.id.journalist1);
        journalist2 = findViewById(R.id.journalist2);
        journalist3 = findViewById(R.id.journalist3);
        journalist4 = findViewById(R.id.journalist4);

        back = findViewById(R.id.back9);
        back.setOnClickListener(view -> Service_9.super.onBackPressed());


        //=================//
        journalist1.setOnClickListener(v -> {
            num = "01712-235827";
            callPhoneNumber();
        });
        journalist2.setOnClickListener(v -> {
            num = "01716-416055";
            callPhoneNumber();
        });
        journalist3.setOnClickListener(v -> {
            num = "01760-333214";
            callPhoneNumber();
        });
        journalist4.setOnClickListener(v -> {
            num = "01728-343748";
            callPhoneNumber();
        });
      /*  journalist5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01";
                callPhoneNumber();
            }
        });*/


    }

    //......................call method.....................//

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber();
            }
        }
    }

    public void callPhoneNumber() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Service_9.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);

            } else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}