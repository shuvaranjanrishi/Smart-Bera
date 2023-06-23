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

public class Service_11 extends AppCompatActivity {


//    AdView mAdView;
//    InterstitialAd mInterstitialAd;
    LottieAnimationView hotel1, hotel2, hotel3, hotel4, hotel5;
    ImageView back;
    public String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service11);


       /* hotel1=findViewById(R.id.hotel1);
        hotel2=findViewById(R.id.hotel2);
        hotel3=findViewById(R.id.hotel3);
        hotel4=findViewById(R.id.hotel4);
        hotel5=findViewById(R.id.hotel5);*/


        back = findViewById(R.id.back11);
        back.setOnClickListener(view -> Service_11.super.onBackPressed());


        //===========//

        /*hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01789-031073";
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
                    ActivityCompat.requestPermissions(Service_11.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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

    //==================================================================================//

    //==============================================Banner ad start=============================//

}