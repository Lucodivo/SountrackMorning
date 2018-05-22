package com.inasweaterpoorlyknit.soundtrackmorning

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.format.DateFormat
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Calendar;

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    private val alarmsList = ArrayList<Alarm>()

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        toast("hour: $hourOfDay minute: $minute")
        alarmsList.add(Alarm(hourOfDay, minute, true))
        existing_alarms_list.adapter.notifyItemInserted(alarmsList.size)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        val newString = stringFromJNI() + doubleFromJNI()
        title = newString

        alarmsList.add(Alarm(8, 1, true))
        alarmsList.add(Alarm(8, 2, false))
        alarmsList.add(Alarm(8, 3, true))

        existing_alarms_list.layoutManager = LinearLayoutManager(this)
        existing_alarms_list.adapter = ExistingAlarmsRecyclerViewAdapter(alarmsList, this)

        add_alarm_button.setOnClickListener {createAlarm()}
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun doubleFromJNI(): Double

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private fun createAlarm() {
        val calendar = Calendar.getInstance()

        TimePickerDialog(this,
                this,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this)).show()

    }

    private fun toast(toastString: String) {
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show()
    }
}