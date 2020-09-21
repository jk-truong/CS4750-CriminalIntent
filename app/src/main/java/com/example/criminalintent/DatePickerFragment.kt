package com.example.criminalintent

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

private const val ARG_DATE = "date"

//This class deals with bringing up a calendar pop up to pick a date.
class DatePickerFragment : DialogFragment() {

    interface Callbacks {
        fun onDateSelected(date: Date)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //This recieves the date the user selects
        //_ is the name of the parameter for DatePicker. we aren't using it so it's named like that.
        val dateListener = DatePickerDialog.OnDateSetListener {
                _: DatePicker, year: Int, month: Int, day: Int ->

            val resultDate : Date = GregorianCalendar(year, month, day).time
            //Cast fragment instance to callback which sends it to CrimeFragment
            targetFragment?.let { fragment ->
                (fragment as Callbacks).onDateSelected(resultDate)
            }
        }
        val date = arguments?.getSerializable(ARG_DATE) as Date //this gets the date from CrimeFragment
        val calendar = Calendar.getInstance()
        calendar.time = date //Sets the date on the calendar so it knows what to show
        val initialYear = calendar.get(Calendar.YEAR)
        val initialMonth = calendar.get(Calendar.MONTH)
        val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(),
            dateListener,
            initialYear,
            initialMonth,
            initialDay
        )
    }

    companion object {
        fun newInstance(date: Date): DatePickerFragment {
            val args = Bundle().apply {
                putSerializable(ARG_DATE, date)
            }

            return DatePickerFragment().apply {
                arguments = args
            }
        }
    }
}