package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class settigsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val btn22: ImageButton = findViewById<ImageButton>(R.id.imageButton)
        btn22.setOnClickListener {
            val intent = Intent(this@settigsActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}