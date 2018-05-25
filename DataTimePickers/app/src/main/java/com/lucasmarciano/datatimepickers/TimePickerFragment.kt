package com.lucasmarciano.datatimepickers


import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.TimePicker
import java.util.*

/**
 * A simple [Fragment] subclass.
 *
 */
class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val mainActivity: MainActivity = activity as MainActivity
        mainActivity.processTimePickerResult(hourOfDay, minute)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar: Calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(activity, this, hour, minute, true)
        return dialog
    }


}
