package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class update_dueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_due)

        val btn19: Button = findViewById<Button>(R.id.button29)
        btn19.setOnClickListener {
            val intent = Intent(this@update_dueActivity,dealActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}