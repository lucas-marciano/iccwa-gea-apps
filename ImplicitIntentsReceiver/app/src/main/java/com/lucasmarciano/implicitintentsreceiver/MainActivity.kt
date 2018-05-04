package com.lucasmarciano.implicitintentsreceiver

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uri: Uri? = intent.data

        uri.let {
            val uriString = "URI: " + it.toString()
            text_uri_message.text = uriString
        }

        if(uri != null){
            val uriString = "URI: " + uri.toString()
            text_uri_message.text = uriString
        }
    }
}
