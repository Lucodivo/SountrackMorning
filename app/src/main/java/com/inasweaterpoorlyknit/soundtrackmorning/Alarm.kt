package com.inasweaterpoorlyknit.soundtrackmorning

enum class AlarmState{
    ON, OFF
}

data class Alarm(val time: String, val state: AlarmState)