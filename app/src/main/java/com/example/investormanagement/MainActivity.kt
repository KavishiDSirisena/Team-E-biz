package com.example.investormanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn1: Button = findViewById<Button>(R.id.buttonNewInvest)
        btn1.setOnClickListener {
            val intent = Intent(this@MainActivity, payment::class.java)
            startActivity(intent)
            finish()
        }

        val btn2: Button = findViewById<Button>(R.id.buttonInvDetails)
        btn2.setOnClickListener {
            val intent = Intent(this@MainActivity, invDetails::class.java)
            startActivity(intent)
            finish()
        }
        val btn10: Button = findViewById<Button>(R.id.button5)
        btn10.setOnClickListener {
            val intent = Intent(this@MainActivity, update::class.java)
            startActivity(intent)
            finish()
        }
    }
}