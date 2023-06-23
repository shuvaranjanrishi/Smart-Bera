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
//import com.google.android.gms.ads.AdView;

public class Service_7 extends AppCompatActivity {
//    AdView mAdView;

    public String num = "";
    ImageView back;
    LottieAnimationView Police1, Police2, Police3, Police4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service7);

        Police1 = findViewById(R.id.police1);
        /*Police2=findViewById(R.id.police2);*/

        back = findViewById(R.id.back7);
        back.setOnClickListener(view -> Service_7.super.onBackPressed());


        //=============Ads start==============//
        /*mAdView=findViewById(R.id.adView);

        mAdView.setVisibility(View.GONE);
*/


        //======Police======/
        Police1.setOnClickListener(v -> {
            num = "01713-374023";
            callPhoneNumber();
        });
      /*  Police2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="017";
                callPhoneNumber();
            }
        });*/


    }


    //.....call method......//

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
                    ActivityCompat.requestPermissions(Service_7.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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