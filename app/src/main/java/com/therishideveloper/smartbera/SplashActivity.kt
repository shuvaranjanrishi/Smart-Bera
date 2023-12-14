package com.therishideveloper.smartbera

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.therishideveloper.smartbera.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    private var progress = 0
    private var animation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.fade_in)
        binding.logoIv.startAnimation(animation)

        val thread = Thread {
            dowork()
            startapp()
        }
        thread.start()
    }

    private fun dowork() {
        progress = 30
        while (progress <= 100) {
            try {
                Thread.sleep(1000)
                binding.progressBar.progress = progress
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            progress += 30
        }
    }

    private fun startapp() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
    }
}