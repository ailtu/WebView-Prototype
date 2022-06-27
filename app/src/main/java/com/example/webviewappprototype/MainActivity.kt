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
        findWV.loadUrl("https://www.urbanovitalino.com.br/") // load the web page
        val webSett = findWV.settings
        webSett.javaScriptEnabled = true // enable javascript
        findWV.webViewClient = WebViewClient() // manage page navigation
        webSett.domStorageEnabled = true // storage data for optimization

        findWV.canGoBack()
        findWV.setOnKeyListener(View.OnKeyListener { _, i, keyEvent ->
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