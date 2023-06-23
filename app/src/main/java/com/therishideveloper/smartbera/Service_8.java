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

public class Service_8 extends AppCompatActivity {

    //    AdView mAdView;
//    InterstitialAd mInterstitialAd;
    public String num = "";
    ImageView back;
    LottieAnimationView lawyer1, lawyer2, lawyer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service8);


        lawyer1 = findViewById(R.id.lawyer1);
        lawyer2 = findViewById(R.id.lawyer2);
/*
        lawyer3=findViewById(R.id.lawyer3);
*/


        back = findViewById(R.id.back8);
        back.setOnClickListener(view -> Service_8.super.onBackPressed());


        //====lawyer=====//

        lawyer1.setOnClickListener(v -> {
            num = "01";
            callPhoneNumber();
        });
        lawyer2.setOnClickListener(v -> {
            num = "01";
            callPhoneNumber();
        });
      /*  lawyer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01718-778704";
                callPhoneNumber();
            }
        });*/


        //====end===//

    }


    //.....call method...//

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
                    ActivityCompat.requestPermissions(Service_8.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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