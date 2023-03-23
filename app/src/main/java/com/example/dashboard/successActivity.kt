package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class successActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success)

        val btn9: Button = findViewById<Button>(R.id.button18)
        btn9.setOnClickListener {
            val intent = Intent(this@successActivity,dealActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}