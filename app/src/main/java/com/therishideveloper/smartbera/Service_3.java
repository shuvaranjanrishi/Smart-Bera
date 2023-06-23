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

public class Service_3 extends AppCompatActivity {
    public String num = "";

//    AdView mAdView;
//    InterstitialAd mInterstitialAd;
    ImageView back;
    LottieAnimationView doner1, doner2, doner3, doner4, doner5, doner6, doner7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service3);


        doner1 = findViewById(R.id.Doner1);
        doner2 = findViewById(R.id.Doner2);
        /*doner4=findViewById(R.id.Doner4);
        doner5=findViewById(R.id.Doner5);
        doner6=findViewById(R.id.Doner6);
        doner7=findViewById(R.id.Doner7);*/
        back = findViewById(R.id.back3);

        back.setOnClickListener(view -> Service_3.super.onBackPressed());


        //===============================Doner===================================================//
        doner1.setOnClickListener(v -> {
            num = "01703-447001";
            callPhoneNumber();
        });

        doner2.setOnClickListener(v -> {
            num = "01772-661139";
            callPhoneNumber();
        });
      /*  doner3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01316-440081";
                callPhoneNumber();
            }
        });
        doner4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01409-443476";
                callPhoneNumber();
            }
        });
        doner5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01771-980500";
                callPhoneNumber();
            }
        });
        doner6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01797-438927";
                callPhoneNumber();
            }
        });
        doner7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01781-779227";
                callPhoneNumber();
            }
        });*/
        //===============================end======================================================//


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
                    ActivityCompat.requestPermissions(Service_3.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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

    //==================//

}