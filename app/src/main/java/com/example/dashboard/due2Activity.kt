package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class due2Activity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.due2)

        val btn17: Button = findViewById<Button>(R.id.button26)
        btn17.setOnClickListener {
            val intent = Intent(this@due2Activity, due_deliganceActivity::class.java)
            startActivity(intent)
            finish()

        }
        val btn18: Button = findViewById<Button>(R.id.button27)
        btn18.setOnClickListener {
            val intent = Intent(this@due2Activity, update_dueActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}