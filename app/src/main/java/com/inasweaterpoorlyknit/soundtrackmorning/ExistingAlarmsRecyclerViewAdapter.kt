package com.inasweaterpoorlyknit.soundtrackmorning

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.existing_alarm_row.view.*

class ExistingAlarmsRecyclerViewAdapter(val items : ArrayList<Alarm>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.existing_alarm_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alarm = items.get(position)

        holder.triggerTime.text = alarm.time

        if(alarm.state == AlarmState.ON) {
            holder.view.setBackgroundColor(Color.GREEN)
        } else {
            holder.view.setBackgroundColor(Color.RED)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val triggerTime = view.trigger_time_text_view
    val view = view
}