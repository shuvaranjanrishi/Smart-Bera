package com.therishideveloper.smartbera;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    /*   private static final String ONESIGNAL_APP_ID = "f099ff64-4ea6-47a9-9067-2697df760571"; */

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView imageMenu;
    TextView tv, tvDate;
    CardView Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, Button10, Button11, Button12, Button13, Button14, Button15, Button16, Button17, Button18, Button19, Button20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = findViewById(R.id.Button1);
        Button2 = findViewById(R.id.Button2);
        Button3 = findViewById(R.id.Button3);
        Button4 = findViewById(R.id.Button4);
        Button5 = findViewById(R.id.Button5);
        Button6 = findViewById(R.id.Button6);
        Button7 = findViewById(R.id.Button7);
        Button8 = findViewById(R.id.Button8);
        Button9 = findViewById(R.id.Button9);
        Button10 = findViewById(R.id.Button10);
        Button11 = findViewById(R.id.Button11);
        Button12 = findViewById(R.id.Button12);
        Button13 = findViewById(R.id.Button13);
        Button14 = findViewById(R.id.Button14);
        Button15 = findViewById(R.id.Button15);
        Button16 = findViewById(R.id.Button16);
        Button17 = findViewById(R.id.Button17);
        Button18 = findViewById(R.id.Button18);
        Button19 = findViewById(R.id.Button19);
        Button20 = findViewById(R.id.Button20);


        /*
//===============================PUSH NOTIFICATION=====================================//

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications();



        //===========================================================================//
*/


        tv = this.findViewById(R.id.mywidget);
        tv.setSelected(true);  // Set focus to the textview

        tvDate = findViewById(R.id.tvDate);
        //Set Date For Cover Section
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
        Date date1 = new Date();
        String s_date = formatter.format(date1);
        tvDate.setText(s_date);

//===========navigation drawer===============//


        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);


        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.Developer:

                    Intent nextActivity = new Intent(MainActivity.this, Developer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 100);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);

                    drawerLayout.closeDrawers();
                    break;

                case R.id.mAbout:
                    Intent nextActivity1 = new Intent(MainActivity.this, About_app.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("VAL", 0);
                    nextActivity1.putExtras(bundle1);
                    startActivity(nextActivity1);

                    drawerLayout.closeDrawers();
                    break;

                /*case R.id.mRate:

                    try {
                        Uri uri = Uri.parse("market://details?id="+getPackageName()+"");
                        Intent goMarket = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(goMarket);
                    }catch (ActivityNotFoundException e){
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()+"");
                        Intent goMarket = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(goMarket);
                    }
                    drawerLayout.closeDrawers();
                    break;*/

                case R.id.mShare:

                    try {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                        String shareMessage = "\nLet me recommend you this application\n\n";
/*
//IMRAN                          shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
*/
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(shareIntent, "choose one"));
                    } catch (Exception e) {
                        //e.toString();
                    }
                    drawerLayout.closeDrawers();
                    break;

                case R.id.mExit:

                    new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.warning).setTitle("বাহির!")
                            .setMessage("আপনি কি বের হতে চান?")
                            .setPositiveButton("হ্যাঁ", (dialog, which) -> {

                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            }).setNegativeButton("না", null).show();

                    drawerLayout.closeDrawers();
                    break;

            }

            return false;
        });
        //------------------------------

        // ------------------------
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(view -> {
            // Code Here
            drawerLayout.openDrawer(GravityCompat.START);
        });


        //===========Image Slider=========================//


        ImageSlider imageSlider;


        imageSlider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.magura1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.magura2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.magura3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.magura4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.magura5, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.magura6, ScaleTypes.FIT));

        imageSlider.setImageList(imageList);


        //==================end==================================//


        Button1.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_1.class);

            startActivity(nextActivity);

        });

        Button2.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_2.class);
            startActivity(nextActivity);

        });


        Button3.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_3.class);
            startActivity(nextActivity);

        });

        Button4.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_4.class);
            startActivity(nextActivity);

        });


        Button5.setOnClickListener(view -> {

            Intent nextActivity = new Intent(MainActivity.this, Doctor_list.class);
            startActivity(nextActivity);

        });

        Button6.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_5.class);
            startActivity(nextActivity);
        });

        Button7.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_6.class);
            startActivity(nextActivity);
        });

        Button8.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_7.class);
            startActivity(nextActivity);
        });

        Button9.setOnClickListener(v -> {
            //Button 1
            Toast.makeText(MainActivity.this, "শীঘ্রই আসছে", Toast.LENGTH_LONG).show();
//            Intent nextActivity = new Intent(MainActivity.this, Service_8.class);
//            startActivity(nextActivity);
        });

        Button10.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_9.class);
            startActivity(nextActivity);
        });

        Button11.setOnClickListener(v -> {
            //Button 1
            Intent nextActivity = new Intent(MainActivity.this, Service_10.class);
            startActivity(nextActivity);
        });

// scince
        Button12.setOnClickListener(v -> {
            //Button 12.
            Intent nextActivity = new Intent(MainActivity.this, Service_11.class);
            startActivity(nextActivity);
        });

        Button13.setOnClickListener(view -> {
            Web_browser.WEBSITE_LINK = "https://www.foodpanda.com.bd/city/pabna";
            Web_browser.WEBSITE_TITLE = "রেস্টুরেন্ট";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);
        });

        Button14.setOnClickListener(view -> {
            Web_browser.WEBSITE_LINK = "https://www.shohoz.com/bus-tickets";
            Web_browser.WEBSITE_TITLE = "বাস টিকেট";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);

        });

        Button15.setOnClickListener(view -> Toast.makeText(MainActivity.this, "শীঘ্রই আসছে", Toast.LENGTH_LONG).show());

        Button16.setOnClickListener(v -> {
            //Button 16
            Intent nextActivity = new Intent(MainActivity.this, Service_12.class);
            startActivity(nextActivity);
        });

        Button17.setOnClickListener(view -> {

            Web_browser.WEBSITE_LINK = "https://bera.pabna.gov.bd/";
            Web_browser.WEBSITE_TITLE = "বেড়া উপজেলা পরিচিতি স্থানসমূহ";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);

        });

        Button18.setOnClickListener(view -> {

            Web_browser.WEBSITE_LINK = "https://www.facebook.com/groups/189051940792725/";
            Web_browser.WEBSITE_TITLE = "Flat Booking.com";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);

        });


        Button19.setOnClickListener(view -> {

            Web_browser.WEBSITE_LINK = "https://razibofficial.blogspot.com/?m=1";
            Web_browser.WEBSITE_TITLE = "আপডেট নিউজ";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);

        });

        Button20.setOnClickListener(view -> {

            Web_browser.WEBSITE_LINK = "https://www.facebook.com/groups/192841586705079";
            Web_browser.WEBSITE_TITLE = "চাকরির খবর";
            Intent myIntent = new Intent(MainActivity.this, Web_browser.class);
            startActivity(myIntent);

        });


    }


    //...back presses exit================//

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    private long mBackPressed;

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {
        // When user press back button

        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {

            Toast.makeText(getBaseContext(), "Press again to exit",
                    Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();

    }
}