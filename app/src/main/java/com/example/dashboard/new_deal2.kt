package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class new_deal2  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_deal2)

        val btn6: Button = findViewById<Button>(R.id.button3)
        btn6.setOnClickListener {
            val intent = Intent(this@new_deal2, successActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btn7: Button = findViewById<Button>(R.id.button16)
        btn7.setOnClickListener {
            val intent = Intent(this@new_deal2, new_dealActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}