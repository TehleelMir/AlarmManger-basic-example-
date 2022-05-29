package com.example.alarmmanger

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanger.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.button.setOnClickListener {
            setupAlarm()
        }
    }

    private fun setupAlarm() {
        val time = Calendar.getInstance().timeInMillis + 10000
        val alarmManger: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        alarmManger.setExact(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )

        /*
            In order to cancel the alarm we have to do the following
            val alarmManger: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

            alarmManger.cancel(pendingIntent)
         */
    }
}