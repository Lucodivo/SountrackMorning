package com.inasweaterpoorlyknit.soundtrackmorning

import android.text.format.DateFormat

class Alarm(val hourOfDay: Int, val minute: Int, var isActive: Boolean) {
    fun getTimeText(is24Hour: Boolean): String {
        if(!is24Hour) {
            if (hourOfDay == 12) {
                return formatTimeUnit(hourOfDay) + ":" + formatTimeUnit(minute) + " PM"
            } else if(hourOfDay > 12) {
                return formatTimeUnit(hourOfDay - 12) + ":" + formatTimeUnit(minute) + " PM"
            } else if(hourOfDay == 0) {
                return "12:" + formatTimeUnit(minute) + " AM"
            } else {
                return formatTimeUnit(hourOfDay) + ":" + formatTimeUnit(minute) + " AM"
            }
        } else {
            return formatTimeUnit(hourOfDay) + ":" + formatTimeUnit(minute)
        }
    }

    private fun formatTimeUnit(timeUnit: Int): String {
        return if (timeUnit > 9) "$timeUnit" else "0$timeUnit"
    }
}