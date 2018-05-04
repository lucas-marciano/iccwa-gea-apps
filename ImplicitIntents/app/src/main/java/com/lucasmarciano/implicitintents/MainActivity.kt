package com.lucasmarciano.implicitintents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebsite(view: View) {
        val url = et_website.text.toString()
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Check if the URL is correct.", Toast.LENGTH_SHORT).show()
        }
    }

    fun openLocation(view: View) {
        val location = et_location.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Check if the Location exist.", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareText(view: View) {
        val text = et_share_this.text.toString()
        ShareCompat.IntentBuilder.
                from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser()

    }


}
