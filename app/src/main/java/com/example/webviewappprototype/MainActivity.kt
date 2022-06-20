package com.example.webviewappprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findWV = findViewById<View>(R.id.WebView) as WebView
        findWV.loadUrl("https://github.com/zeld4coffee") // load the web page

         val webSettings = findWV.settings
        // webSettings.javaScriptEnabled = true

        findWV.webViewClient = WebViewClient()

        findWV.canGoBack()
        findWV.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_BACK
                && keyEvent.action == MotionEvent.ACTION_UP
                && findWV.canGoBack()
            ) {
                findWV.goBack()
                return@OnKeyListener true
            }
            false
        })
    }
}