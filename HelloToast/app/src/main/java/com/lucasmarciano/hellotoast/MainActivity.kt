package com.lucasmarciano.hellotoast

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    val context = this
    var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Button to show a toast
     * @param view View
     */
    fun showToast(view: View) {
        Toast.makeText(context, getString(R.string.toast_message) + " (" + mCount + ")", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("SetTextI18n")
    fun countNumber(view: View) {
        mCount++
        show_count.text = Integer.toString(mCount)
    }
}
