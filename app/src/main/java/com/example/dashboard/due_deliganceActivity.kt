package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class due_deliganceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.due_delligance)

        val btn16: Button = findViewById<Button>(R.id.button23)
        btn16.setOnClickListener {
            val intent = Intent(this@due_deliganceActivity, due2Activity::class.java)
            startActivity(intent)
            finish()

        }

        val btn18: Button = findViewById<Button>(R.id.button28)
        btn18.setOnClickListener {
            val intent = Intent(this@due_deliganceActivity, dealActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}