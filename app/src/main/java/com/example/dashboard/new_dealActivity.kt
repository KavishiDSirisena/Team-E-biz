package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class new_dealActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_deal)

        val btn5: Button = findViewById<Button>(R.id.button15)
        btn5.setOnClickListener {
            val intent = Intent(this@new_dealActivity, new_deal2::class.java)
            startActivity(intent)
            finish()
        }

        val btn8: Button = findViewById<Button>(R.id.button17)
        btn8.setOnClickListener {
            val intent = Intent(this@new_dealActivity, dealActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}