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

public class Service_4 extends AppCompatActivity {
    public String num = "";

    ImageView back;
    LottieAnimationView Ambulence1, Ambulence2, Ambulence3, Ambulence4, Ambulence5, Ambulence6, Ambulence7, Ambulence8, Ambulence9, Ambulence10;
//
//    AdView mAdView;
//    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service4);


        Ambulence1 = findViewById(R.id.Ambulence1);
        /*Ambulence2=findViewById(R.id.Ambulence2);
        Ambulence3=findViewById(R.id.Ambulence3);*/
        /*Ambulence4=findViewById(R.id.Ambulence4);
        Ambulence5=findViewById(R.id.Ambulence5);
        Ambulence6=findViewById(R.id.Ambulence6);
        Ambulence7=findViewById(R.id.Ambulence7);
        Ambulence8=findViewById(R.id.Ambulence8);
        Ambulence9=findViewById(R.id.Ambulence9);
        Ambulence10=findViewById(R.id.Ambulence10);
*/
        back = findViewById(R.id.back4);
        back.setOnClickListener(view -> Service_4.super.onBackPressed());


        //===============Ambulence===============//
        Ambulence1.setOnClickListener(v -> {
            num = "01317-452581";
            callPhoneNumber();
        });


       /* Ambulence2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01";
                callPhoneNumber();
            }
        });
        Ambulence3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01";
                callPhoneNumber();
            }
        });*/

        //.....................


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
                    ActivityCompat.requestPermissions(Service_4.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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

    //===================//


}