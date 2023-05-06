package com.example.investormanagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class cardDetails: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_details)

        val btn5: Button = findViewById<Button>(R.id.btnPay)
        btn5.setOnClickListener {
            val intent = Intent(this@cardDetails, confirmation::class.java)
            startActivity(intent)
            finish()
        }

        val btn6: Button = findViewById<Button>(R.id.btnBack3)
        btn6.setOnClickListener {
            val intent = Intent(this@cardDetails, payment2::class.java)
            startActivity(intent)
            finish()
        }

    }
}