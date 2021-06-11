package com.example.tabunganku

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import com.example.tabunganku.databinding.ActivitySplashScreenBinding
import com.example.tabunganku.main.MainActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var splashScreenBinding: ActivitySplashScreenBinding

    companion object{
        const val SPLASH_TIME: Long = 8000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        window.requestFeature(Window.FEATURE_NO_TITLE)

        setContentView(splashScreenBinding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },SPLASH_TIME)
    }
}