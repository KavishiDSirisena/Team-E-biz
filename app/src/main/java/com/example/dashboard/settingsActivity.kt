package com.example.dashboard

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class settingsActivity : AppCompatActivity() {
        lateinit var switcher: Switch
        var nightMODE: Boolean = false
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.settings)

            supportActionBar?.hide()
            switcher = findViewById<Switch>(R.id.switch2)

            sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
            nightMODE = sharedPreferences.getBoolean("night", false)

            if (nightMODE) {
                switcher.isChecked = true
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            switcher.setOnClickListener {
                if (nightMODE) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor = sharedPreferences.edit()
                    editor.putBoolean("night", false)
                    editor.apply()
                    nightMODE = false
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor = sharedPreferences.edit()
                    editor.putBoolean("night", true)
                    editor.apply()
                    nightMODE = true
                }
            }

            val btn22: ImageButton = findViewById<ImageButton>(R.id.imageButton)
            btn22.setOnClickListener {
                val intent = Intent(this@settingsActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

