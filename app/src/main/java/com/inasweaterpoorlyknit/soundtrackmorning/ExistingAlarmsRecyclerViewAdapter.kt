package com.inasweaterpoorlyknit.soundtrackmorning

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.existing_alarm_row.view.*

class ExistingAlarmsRecyclerViewAdapter(val items : ArrayList<Alarm>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.existing_alarm_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alarm = items[position]

        var timeText = alarm.getTimeText(DateFormat.is24HourFormat(context))

        holder.triggerTime.text = timeText

        if(alarm.isActive) {
            holder.view.setBackgroundColor(Color.GREEN)
        } else {
            holder.view.setBackgroundColor(Color.RED)
        }

        holder.view.setOnClickListener( {
            items[position] = Alarm(alarm.hourOfDay, alarm.minute, !alarm.isActive)
            notifyItemChanged(position)
        } )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val triggerTime = view.trigger_time_text_view
    val view = view
}