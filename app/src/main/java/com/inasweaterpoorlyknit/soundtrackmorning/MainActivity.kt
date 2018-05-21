package com.inasweaterpoorlyknit.soundtrackmorning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        val newString = stringFromJNI() + doubleFromJNI()
        title = newString

        val alarmsList = ArrayList<Alarm>()
        alarmsList.add(Alarm("8:01AM", AlarmState.ON))
        alarmsList.add(Alarm("8:02AM", AlarmState.OFF))
        alarmsList.add(Alarm("8:03AM", AlarmState.ON))

        existing_alarms_list.layoutManager = LinearLayoutManager(this)
        existing_alarms_list.adapter = ExistingAlarmsRecyclerViewAdapter(alarmsList, this)
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
}
