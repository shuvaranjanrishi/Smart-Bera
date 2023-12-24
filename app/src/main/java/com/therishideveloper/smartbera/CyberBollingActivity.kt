package com.therishideveloper.smartbera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.therishideveloper.smartbera.databinding.ActivityCyberBollingBinding
import com.therishideveloper.smartbera.databinding.ActivityMainBinding

class CyberBollingActivity : AppCompatActivity() {

    private val TAG = "CyberBollingActivity"

    private var _binding: ActivityCyberBollingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCyberBollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()

        initListeners()
    }

    private fun initVariables() {
        if (intent != null) {
            val previousExtras = intent.extras
            if (previousExtras != null) {
                if (previousExtras.containsKey("SUMMARY")) {
                   val title = previousExtras.getString("TITLE")!!
                   val summary = previousExtras.getString("SUMMARY")!!
                    binding.titleTv.text = title
                    binding.summaryTv.text = summary
                }
            }
        }
    }

    private fun initListeners() {
        binding.goBtn.setOnClickListener {
            val myIntent = Intent(this, Web_browser::class.java)
            startActivity(myIntent)
        }
    }
}