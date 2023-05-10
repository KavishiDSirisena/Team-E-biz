package com.example.investormanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class payment2: AppCompatActivity() {

    private lateinit var Name: TextView
    private lateinit var Amount: TextView

    private lateinit var btnNext: Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName: String
    private lateinit var sAmount: String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment2)

        auth = Firebase.auth
        database = Firebase.database.reference

        Name = findViewById(R.id.editTextTextPersonName)
        Amount = findViewById(R.id.editTextAmount)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            saveData()
            updateUI()
        }

        val btn7: Button = findViewById<Button>(R.id.btnBack2)
        btn7.setOnClickListener {
            val intent = Intent(this@payment2, payment::class.java)
            startActivity(intent)
            finish()
        }
    }



    private fun saveData() {
        sName = Name.text.toString().trim()
        sAmount = Amount.text.toString().trim()

        database = FirebaseDatabase.getInstance().getReference("payment2")
        val details2 = details2(sName,sAmount)
        database.child(sName).setValue(details2).addOnSuccessListener {

            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@payment2, cardDetails::class.java)
        startActivity(intent)
        finish()
    }

}