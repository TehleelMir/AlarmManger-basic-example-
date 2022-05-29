package com.example.alarmmanger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Alarm got fired", Toast.LENGTH_SHORT).show()
        Log.i("here22", "Alarm worked fine...............................................................")
    }
}