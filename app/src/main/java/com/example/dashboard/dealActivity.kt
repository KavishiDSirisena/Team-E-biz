package com.example.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class dealActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deal_flow)

        val btn4: Button = findViewById<Button>(R.id.button12)
        btn4.setOnClickListener {
            val intent = Intent(this@dealActivity, new_dealActivity::class.java)
            startActivity(intent)
            finish()

        }

        val btn10: Button = findViewById<Button>(R.id.button21)
        btn10.setOnClickListener {
            val intent = Intent(this@dealActivity, homeActivity::class.java)
            startActivity(intent)
            finish()

        }

        val btn11: Button = findViewById<Button>(R.id.button13)
        btn11.setOnClickListener {
            val intent = Intent(this@dealActivity, deal_viewActivity::class.java)
            startActivity(intent)
            finish()

        }
        val btn15: Button = findViewById<Button>(R.id.button14)
        btn15.setOnClickListener {
            val intent = Intent(this@dealActivity, due_deliganceActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}