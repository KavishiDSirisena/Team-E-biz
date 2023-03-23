package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class deal_viewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deal_view)

        val btn12: Button = findViewById<Button>(R.id.button20)
        btn12.setOnClickListener {
            val intent = Intent(this@deal_viewActivity, dealActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}