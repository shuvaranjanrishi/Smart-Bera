package com.therishideveloper.smartbera

import android.content.Context

class MainMenuViewModel {
    fun getMainMenus(context: Context): List<MainMenu> {
        return listOf(
            MainMenu(1, context.getString(R.string.cyber_bolling), R.drawable.menu),
            MainMenu(2, context.getString(R.string.female_torture), R.drawable.menu),
            MainMenu(3, context.getString(R.string.depression_and_emotional_release), R.drawable.menu),
            MainMenu(4, context.getString(R.string.carrier_thought), R.drawable.menu),
            MainMenu(5, context.getString(R.string.business_online_ad), R.drawable.menu),
            MainMenu(6, context.getString(R.string.passed_ssc_hsc), R.drawable.menu),
            MainMenu(7, context.getString(R.string.islamic_question), R.drawable.menu),
            MainMenu(8, context.getString(R.string.humanitarian_appeal), R.drawable.menu),
            MainMenu(9, context.getString(R.string.spoken_english), R.drawable.menu),
            MainMenu(10, context.getString(R.string.known_unknown_and_science), R.drawable.menu),
            MainMenu(11, context.getString(R.string.inspirational), R.drawable.menu),
            MainMenu(12, context.getString(R.string.life_oriented_thinking), R.drawable.menu),
            MainMenu(13, context.getString(R.string.health_care), R.drawable.menu),
        )
    }
}