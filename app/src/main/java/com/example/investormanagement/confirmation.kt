package com.example.investormanagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class confirmation: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation)

        val btn7: Button = findViewById<Button>(R.id.btnHome)
        btn7.setOnClickListener {
            val intent = Intent(this@confirmation, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

            val btn8: Button = findViewById<Button>(R.id.btnHome2)
            btn8.setOnClickListener {
                val intent = Intent(this@confirmation, feedback::class.java)
                startActivity(intent)
                finish()
            }

    }
}