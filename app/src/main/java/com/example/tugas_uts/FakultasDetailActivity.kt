package com.example.tugas_uts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fakultas_list_item.*

class FakultasDetailActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
            var nama=intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var detail_fakultas=intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            var foto=intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            textView.text = nama
            textView5.text = detail_fakultas
            imageView2.setImageResource(foto)

        }

    }
}