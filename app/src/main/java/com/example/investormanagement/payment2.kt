package com.example.investormanagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class payment2: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment2)

        val btn2: Button = findViewById<Button>(R.id.btnNext)
        btn2.setOnClickListener {
            val intent = Intent(this@payment2, cardDetails::class.java)
            startActivity(intent)
            finish()
        }

        val btn7: Button = findViewById<Button>(R.id.btnBack2)
        btn7.setOnClickListener {
            val intent = Intent(this@payment2, payment::class.java)
            startActivity(intent)
            finish()
        }
    }
}