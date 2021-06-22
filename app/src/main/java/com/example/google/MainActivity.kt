package com.example.google

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    lateinit var Google:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val Google = findViewById<View>(R.id.web) as WebView
        Google.loadUrl("https://www.google.com/")

        val webSetting = Google.settings
        webSetting.javaScriptEnabled = true
        Google.webViewClient = WebViewClient()

        Google.goBack()
        Google.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                    && event.action == MotionEvent.ACTION_UP
                    && Google.canGoBack()){
                Google.goBack()
                return@OnKeyListener true
            }
            false
        })



    }
}
