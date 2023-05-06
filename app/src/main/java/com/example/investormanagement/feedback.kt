package com.example.investormanagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class feedback: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback)

        val btn8: Button = findViewById<Button>(R.id.btnSubmit)
        btn8.setOnClickListener {
            val intent = Intent(this@feedback, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}