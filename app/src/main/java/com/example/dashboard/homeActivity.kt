package com.example.dashboard

import android.content.Intent
import android.app.Activity

import android.os.Bundle
import android.widget.Button

class homeActivity:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val btn1: Button = findViewById<Button>(R.id.button5)
        btn1.setOnClickListener {
            val intent = Intent(this@homeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        val btn3: Button = findViewById<Button>(R.id.button10)
        btn3.setOnClickListener {
            val intent = Intent(this@homeActivity, dealActivity::class.java)
            startActivity(intent)
            finish()
        }
        val btn21: Button = findViewById<Button>(R.id.button9)
        btn21.setOnClickListener {
            val intent = Intent(this@homeActivity,settingsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}