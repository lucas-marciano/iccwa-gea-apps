package com.lucasmarciano.datatimepickers

import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDataPicker(view: View){
        val dialog: DialogFragment = DatePickerFragment()
        dialog.show(supportFragmentManager, getString(R.string.date_picker))
    }

    fun showTimePicker(view: View){
        val dialog: DialogFragment = TimePickerFragment()
        dialog.show(supportFragmentManager, getString(R.string.time_picker))
    }


    fun processDataPickerResult(year: Int, month: Int, day: Int){
        val monthLabel = (month + 1).toString()
        Toast.makeText(this, "Date selected: $day/$monthLabel/$year", Toast.LENGTH_LONG).show()
    }

    fun processTimePickerResult(hour: Int, minute: Int){
        Toast.makeText(this, "Time selected: $hour:$minute", Toast.LENGTH_LONG).show()
    }
}
