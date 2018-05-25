package com.lucasmarciano.datatimepickers


import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.widget.DatePicker
import org.jetbrains.annotations.NotNull
import java.util.*

/**
 * A simple [Fragment] subclass.
 *
 */
class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        var mainActivity: MainActivity = activity as MainActivity
        mainActivity.processDataPickerResult(year, month, day)
    }

    @NotNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(activity, this, year, month, day)
        return dialog
    }

}
