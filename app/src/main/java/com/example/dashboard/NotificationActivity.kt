package com.example.dashboard

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationActivity  : AppCompatActivity() {

    private lateinit var notifyBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification)

        notifyBtn = findViewById(R.id.notify_btn)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "My Notification"
            val channelName = "My Notification"
            val channelImportance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId, channelName, channelImportance).apply {
                enableLights(true)
                lightColor = Color.RED
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        notifyBtn.setOnClickListener {
            val builder = NotificationCompat.Builder(this, "My Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("E-biz application")
                .setContentText("In use")
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                notify(1, builder.build())
            }
        }

        val btn73: Button = findViewById<Button>(R.id.button22)
        btn73.setOnClickListener {
            val intent = Intent(this@NotificationActivity, settingsActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}