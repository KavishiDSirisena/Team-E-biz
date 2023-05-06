package com.example.welcom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btn: Button = findViewById<Button>(R.id.button11111)
        btn.setOnClickListener {
            val intent = Intent(this@MainActivity,Login_e::class.java)
            startActivity(intent)
            finish()
        }

    }
}