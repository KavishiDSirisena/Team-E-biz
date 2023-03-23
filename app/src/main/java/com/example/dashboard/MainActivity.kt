package com.example.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn2: Button = findViewById<Button>(R.id.button6)
        btn2.setOnClickListener {
            val intent = Intent(this@MainActivity,homeActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}