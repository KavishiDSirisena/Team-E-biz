package com.example.profile.activities


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.profile.R

class Optionsclz : AppCompatActivity() {

    private lateinit var btnInsertData:Button
    private lateinit var btnViewData:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback_options)

        btnInsertData = findViewById(R.id.button2)
        btnViewData=findViewById(R.id.button1)


        btnInsertData.setOnClickListener {
            val intent = Intent(this@Optionsclz, FeedbckInsert::class.java)
            startActivity(intent)
        }

        btnViewData.setOnClickListener {
            val intent = Intent(this@Optionsclz,FetchingActivity::class.java)
            startActivity(intent)
        }





    }
}
