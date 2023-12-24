package com.therishideveloper.smartbera

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.therishideveloper.smartbera.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /*   private static final String ONESIGNAL_APP_ID = "f099ff64-4ea6-47a9-9067-2697df760571"; */

    private val TAG = "MainActivity"

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var toggle: ActionBarDrawerToggle? = null
//    private val mainMenuViewModel by viewModels<MainMenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMainMenu()

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

        binding.mywidget.isSelected = true
        val formatter = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        formatter.timeZone = TimeZone.getDefault()
        val date1 = Date()
        val s_date = formatter.format(date1)
        binding.tvDate.text = s_date

        toggle =
            ActionBarDrawerToggle(
                this@MainActivity,
                binding.drawerLayout,
                R.string.open,
                R.string.close
            )
        binding.drawerLayout.addDrawerListener(toggle!!)
        toggle!!.syncState()

        binding.navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.Developer -> {
                    val nextActivity = Intent(this@MainActivity, Developer::class.java)
                    val bundle = Bundle()
                    bundle.putInt("VAL", 100)
                    nextActivity.putExtras(bundle)
                    startActivity(nextActivity)
                    binding.drawerLayout.closeDrawers()
                }

                R.id.mAbout -> {
                    val nextActivity1 = Intent(this@MainActivity, About_app::class.java)
                    val bundle1 = Bundle()
                    bundle1.putInt("VAL", 0)
                    nextActivity1.putExtras(bundle1)
                    startActivity(nextActivity1)
                    binding.drawerLayout.closeDrawers()
                }

                R.id.mShare -> {
                    try {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                        val shareMessage =
                            "\nLet me recommend you this application\n\n"
                        /*
    //         shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
    */
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                    } catch (e: Exception) {
                    }
                    binding.drawerLayout.closeDrawers()
                }

                R.id.mExit -> {
                    AlertDialog.Builder(this@MainActivity)
                        .setIcon(R.drawable.warning).setTitle("বাহির!")
                        .setMessage("আপনি কি বের হতে চান?")
                        .setPositiveButton(
                            "হ্যাঁ"
                        ) { dialog: DialogInterface?, which: Int ->
                            val intent = Intent(Intent.ACTION_MAIN)
                            intent.addCategory(Intent.CATEGORY_HOME)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        }.setNegativeButton("না", null).show()
                    binding.drawerLayout.closeDrawers()
                }
            }
            false
        }

        binding.imageMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.magura1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.magura2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.magura3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.magura4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.magura5, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.magura6, ScaleTypes.FIT))
        binding.imageSlider.setImageList(imageList)

//        binding.Button1.setOnClickListener {
//            //Button 1
//            val nextActivity = Intent(this@MainActivity, Service_1::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button2.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_2::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button3.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_3::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button4.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_4::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button5.setOnClickListener {
//            val nextActivity = Intent(
//                this@MainActivity,
//                Doctor_list::class.java
//            )
//            startActivity(nextActivity)
//        }
//        binding.Button6.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_5::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button7.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_6::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button8.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_7::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button9.setOnClickListener {
//            Toast.makeText(this@MainActivity, "শীঘ্রই আসছে", Toast.LENGTH_LONG).show()
//        }
//        binding.Button10.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_9::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button11.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_10::class.java)
//            startActivity(nextActivity)
//        }
//
//        binding.Button12.setOnClickListener {
//            val nextActivity = Intent(this@MainActivity, Service_11::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button13.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://www.foodpanda.com.bd/city/pabna"
//            Web_browser.WEBSITE_TITLE = "রেস্টুরেন্ট"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
//        binding.Button14.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://www.shohoz.com/bus-tickets"
//            Web_browser.WEBSITE_TITLE = "বাস টিকেট"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
//        binding.Button15.setOnClickListener {
//            Toast.makeText(
//                this@MainActivity,
//                "শীঘ্রই আসছে",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//        binding.Button16.setOnClickListener {
//            //Button 16
//            val nextActivity = Intent(this@MainActivity, Service_12::class.java)
//            startActivity(nextActivity)
//        }
//        binding.Button17.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://bera.pabna.gov.bd/"
//            Web_browser.WEBSITE_TITLE = "বেড়া উপজেলা পরিচিতি স্থানসমূহ"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
//        binding.Button18.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://www.facebook.com/groups/189051940792725/"
//            Web_browser.WEBSITE_TITLE = "Flat Booking.com"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
//        binding.Button19.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://razibofficial.blogspot.com/?m=1"
//            Web_browser.WEBSITE_TITLE = "আপডেট নিউজ"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
//        binding.Button20.setOnClickListener {
//            Web_browser.WEBSITE_LINK = "https://www.facebook.com/groups/192841586705079"
//            Web_browser.WEBSITE_TITLE = "চাকরির খবর"
//            val myIntent = Intent(this@MainActivity, Web_browser::class.java)
//            startActivity(myIntent)
//        }
    }

    private fun initMainMenu() {
        val adapter = MainMenuAdapter(::onMenuClicked)
        binding.mainMenuRv.adapter = adapter
        adapter.submitList(MainMenuViewModel().getMainMenus(this))

//        mainMenuViewModel.dataList.observe(this) {
//            adapter.submitList(it)
//        }
    }

    private fun onMenuClicked(mainMenu: MainMenu) {
        if (mainMenu.id == 1) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.summary_cyber_bolling)
            )
        } else if (mainMenu.id == 2) {
            changePage(
                getString(R.string.link_female_torture),
                getString(R.string.female_torture),
                getString(R.string.summary_female_torture)
            )
        } else if (mainMenu.id == 3) {
            changePage(
                getString(R.string.link_depression_and_emotional_release),
                getString(R.string.depression_and_emotional_release),
                getString(R.string.summary_depression_and_emotional_release)
            )
        } else if (mainMenu.id == 4) {
            changePage(
                getString(R.string.link_carrier_thought),
                getString(R.string.carrier_thought),
                getString(R.string.summary_carrier_thought)
            )
        } else if (mainMenu.id == 5) {
            changePage(
                getString(R.string.link_university_admission),
                getString(R.string.university_admission),
                getString(R.string.summary_university_admission)
            )
        } else if (mainMenu.id == 6) {
            changePage(
                getString(R.string.link_business_online_ad),
                getString(R.string.business_online_ad),
                getString(R.string.summary_business_online_ad)
            )
        } else if (mainMenu.id == 7) {
            changePage(
                getString(R.string.link_passed_ssc_hsc),
                getString(R.string.passed_ssc_hsc),
                getString(R.string.summary_passed_ssc_hsc)
            )
        } else if (mainMenu.id == 8) {
            changePage(
                getString(R.string.link_islamic_question),
                getString(R.string.islamic_question),
                getString(R.string.summary_islamic_question)
            )
        } else if (mainMenu.id == 9) {
            changePage(
                getString(R.string.link_humanitarian_appeal),
                getString(R.string.humanitarian_appeal),
                getString(R.string.summary_humanitarian_appeal)
            )
        } else if (mainMenu.id == 10) {
            changePage(
                getString(R.string.link_spoken_english),
                getString(R.string.spoken_english),
                getString(R.string.summary_spoken_english)
            )
        } else if (mainMenu.id == 11) {
            changePage(
                getString(R.string.link_known_unknown_and_science),
                getString(R.string.known_unknown_and_science),
                getString(R.string.summary_known_unknown_and_science)
            )
        } else if (mainMenu.id == 12) {
            changePage(
                getString(R.string.link_inspirational),
                getString(R.string.inspirational),
                getString(R.string.summary_inspirational)
            )
        } else if (mainMenu.id == 13) {
            changePage(
                getString(R.string.link_life_oriented_thinking),
                getString(R.string.life_oriented_thinking),
                getString(R.string.summary_life_oriented_thinking)
            )
        } else if (mainMenu.id == 14) {
            changePage(
                getString(R.string.link_health_care),
                getString(R.string.health_care),
                getString(R.string.summary_health_care)
            )
        } else if (mainMenu.id == 15) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.cyber_bolling)
            )
        } else if (mainMenu.id == 16) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.cyber_bolling)
            )
        } else if (mainMenu.id == 18) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.cyber_bolling)
            )
        } else if (mainMenu.id == 19) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.cyber_bolling)
            )
        } else if (mainMenu.id == 20) {
            changePage(
                getString(R.string.link_cyber_bolling),
                getString(R.string.cyber_bolling),
                getString(R.string.cyber_bolling)
            )
        }
    }

    private fun changePage(link: String, title: String, summary: String) {
        Web_browser.WEBSITE_LINK = link
        Web_browser.WEBSITE_TITLE = title
        startActivity(
            Intent(this, CyberBollingActivity::class.java)
                .putExtra("TITLE", "" + title)
                .putExtra(
                    "SUMMARY",
                    "" + summary
                )
        )
    }


    private var mBackPressed: Long = 0

    override fun onBackPressed() {
        super.onBackPressed()
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            Toast.makeText(
                baseContext, "Press again to exit",
                Toast.LENGTH_SHORT
            ).show()
        }
        mBackPressed = System.currentTimeMillis()
    }

    companion object {
        private const val TIME_INTERVAL = 2000
    }
}
//353