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

public class Service_2 extends AppCompatActivity {
//    AdView mAdView;
//    InterstitialAd mInterstitialAd;


    public String num = "";
    ImageView back2;
    LottieAnimationView Hospital1, Hospital2, Hospital3, Hospital4, Hospital5, Hospital6, Hospital7, Hospital8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);


        Hospital1 = findViewById(R.id.Hospital1);

       /* Hospital2=findViewById(R.id.Hospital2);
        Hospital3=findViewById(R.id.Hospital3);
        Hospital4=findViewById(R.id.Hospital4);
        Hospital5=findViewById(R.id.Hospital5);
        Hospital6=findViewById(R.id.Hospital6);
        Hospital7=findViewById(R.id.Hospital7);
        Hospital8=findViewById(R.id.Hospital8);*/

        back2 = findViewById(R.id.back2);

//        mAdView = findViewById(R.id.adView);
//        mAdView.setVisibility(View.GONE);


        back2.setOnClickListener(view -> Service_2.super.onBackPressed());


        Hospital1.setOnClickListener(v -> {
            num = "01712-986566";
            callPhoneNumber();
        });
  /*      Hospital2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=" 01789-122193";
                callPhoneNumber();
            }
        });
        Hospital3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01715-119110";
                callPhoneNumber();
            }
        });
        Hospital4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01729-033018";
                callPhoneNumber();
            }
        });
        Hospital5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01311-444901";
                callPhoneNumber();
            }
        });
        Hospital6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01712-310309";
                callPhoneNumber();
            }
        });
        Hospital7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01715-534855";
                callPhoneNumber();
            }
        });
        Hospital8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01766-661177";
                callPhoneNumber();
            }
        });
*/

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
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Service_2.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //==================================================================================//


}