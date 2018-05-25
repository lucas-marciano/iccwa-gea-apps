package com.lucasmarciano.keyboardsamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var mSpinnerLabel: String = ""
    val TAG: String = "MainActivity"

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.i(TAG, "Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mSpinnerLabel = parent?.getItemAtPosition(position).toString()
        showMessage(view!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label_spinner.onItemSelectedListener = this
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        label_spinner.adapter = adapter
    }

    fun showMessage(view: View){
        val message: String = et_message.text.toString()
        tv_phone.text =  "Phone number: $message - $mSpinnerLabel"
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
