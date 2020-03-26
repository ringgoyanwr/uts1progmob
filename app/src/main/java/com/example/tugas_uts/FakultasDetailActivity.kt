package com.example.tugas_uts

import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.web_view.*

class FakultasDetailActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_REFERRER)) {
            var nama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var detail_fakultas = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            var edit = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_PROCESS_TEXT)
            var link1 = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
            var foto1 = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            textView.text = nama
            textView3.text = edit
            textView7.text = link1
            textView5.text = detail_fakultas
            imageView2.setImageResource(foto1)

        }
        button.setOnClickListener({
            setContentView(R.layout.web_view)
            wv.loadUrl("https:" + textView3.text.toString())
            wv.settings.javaScriptEnabled = true
        }
        )
        button2.setOnClickListener {
            pencetEmail(textView7.text.toString())
        }


        class MyWebViewClient : WebViewClient() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
    }

    private fun pencetEmail(email: String) {
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT EMAIL")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "ISI EMAIL")
        startActivity(Intent.createChooser(mailIntent, "Pilih Email ..."))

    }
}