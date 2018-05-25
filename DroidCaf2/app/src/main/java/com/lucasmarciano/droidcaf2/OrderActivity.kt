package com.lucasmarciano.droidcaf2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
    }

    fun onRadioButtonClicked(view: View){
        val message = when(view.id) {
            R.id.sameday -> resources.getString(R.string.radio_label_sameday)
            R.id.pickup -> resources.getString(R.string.radio_label_pickup)
            R.id.nextDay -> resources.getString(R.string.radio_label_nextday)
            else -> "Nothing clicked."
        }

        showToast(message)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
