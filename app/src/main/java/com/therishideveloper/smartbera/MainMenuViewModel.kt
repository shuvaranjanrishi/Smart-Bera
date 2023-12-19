package com.therishideveloper.smartbera

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class MainMenuViewModel  {
    fun getMainMenus(context: Context): List<MainMenu> {
        return listOf(
            MainMenu(1, context.getString(R.string.cyber_bolling), R.drawable.cyber_bolling),
            MainMenu(2, context.getString(R.string.female_torture), R.drawable.female_torture),
            MainMenu(3, context.getString(R.string.depression_and_emotional_release), R.drawable.depression_and_emotional_release),
            MainMenu(4, context.getString(R.string.carrier_thought), R.drawable.carrier_thought),
            MainMenu(5, context.getString(R.string.university_admission), R.drawable.university_admission),
            MainMenu(6, context.getString(R.string.business_online_ad), R.drawable.business_online_ad),
            MainMenu(7, context.getString(R.string.passed_ssc_hsc), R.drawable.passed_ssc_hsc),
            MainMenu(8, context.getString(R.string.islamic_question), R.drawable.islamic_question),
            MainMenu(9, context.getString(R.string.humanitarian_appeal), R.drawable.humanitarian_appeal),
            MainMenu(10, context.getString(R.string.spoken_english), R.drawable.spoken_english),
            MainMenu(11, context.getString(R.string.known_unknown_and_science), R.drawable.known_unknown_and_science),
            MainMenu(12, context.getString(R.string.inspirational), R.drawable.inspirational),
            MainMenu(13, context.getString(R.string.life_oriented_thinking), R.drawable.life_oriented_thinking),
            MainMenu(14, context.getString(R.string.health_care), R.drawable.health_care),
            MainMenu(15, context.getString(R.string.news_paper), R.drawable.news),
            MainMenu(16, context.getString(R.string.blood_donor), R.drawable.blood),
            MainMenu(17, context.getString(R.string.ambulance), R.drawable.ambulance),
            MainMenu(18, context.getString(R.string.doctor), R.drawable.doctor),
            MainMenu(19, context.getString(R.string.fire_service), R.drawable.fire),
            MainMenu(20, context.getString(R.string.police), R.drawable.police),
            MainMenu(21, context.getString(R.string.electrician), R.drawable.worker),
            MainMenu(22, context.getString(R.string.journalist), R.drawable.journalist),
            MainMenu(23, context.getString(R.string.electricity), R.drawable.electry),
            MainMenu(24, context.getString(R.string.science_practice_foundation), R.drawable.science),
            MainMenu(25, context.getString(R.string.restaurant), R.drawable.resturent),
            MainMenu(26, context.getString(R.string.bus_ticket), R.drawable.bus),
            MainMenu(27, context.getString(R.string.rail_ticket), R.drawable.rail),
            MainMenu(28, context.getString(R.string.e_aid), R.drawable.e_seba),
            MainMenu(29, context.getString(R.string.place_introduce), R.drawable.place),
            MainMenu(30, context.getString(R.string.house_rent), R.drawable.rent),
            MainMenu(31, context.getString(R.string.news_update), R.drawable.news),
            MainMenu(32, context.getString(R.string.job_news), R.drawable.job),
            MainMenu(33, context.getString(R.string.help_line), R.drawable.help),
        )
    }


//    private val _menuLiveData = MutableLiveData<List<MainMenu>>().apply {
//        val list = listOf(
//            MainMenu(1, context.getString(R.string.cyber_bolling), R.drawable.menu),
//            MainMenu(2, context.getString(R.string.female_torture), R.drawable.menu),
//            MainMenu(
//                3,
//                context.getString(R.string.depression_and_emotional_release),
//                R.drawable.menu
//            ),
//            MainMenu(4,  .getString(R.string.carrier_thought), R.drawable.menu),
//            MainMenu(5, context.getString(R.string.business_online_ad), R.drawable.menu),
//            MainMenu(6, context.getString(R.string.passed_ssc_hsc), R.drawable.menu),
//            MainMenu(7, context.getString(R.string.islamic_question), R.drawable.menu),
//            MainMenu(8, context.getString(R.string.humanitarian_appeal), R.drawable.menu),
//            MainMenu(9, context.getString(R.string.spoken_english), R.drawable.menu),
//            MainMenu(10, context.getString(R.string.known_unknown_and_science), R.drawable.menu),
//            MainMenu(11, context.getString(R.string.inspirational), R.drawable.menu),
//            MainMenu(12, context.getString(R.string.life_oriented_thinking), R.drawable.menu),
//            MainMenu(13, context.getString(R.string.health_care), R.drawable.menu),
//        )
//        value = list
//    }
//    val dataList: LiveData<List<MainMenu>> = _menuLiveData
}