package com.example.welcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btn: Button = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val intent = Intent(this@MainActivity, signup::class.java)
            startActivity(intent)
            finish()
        }

    }
}