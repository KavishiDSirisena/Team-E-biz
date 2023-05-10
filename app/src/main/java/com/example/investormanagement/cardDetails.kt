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

class cardDetails: AppCompatActivity() {

    private lateinit var Name: TextView
    private lateinit var AccountNo: TextView

    private lateinit var btnPay: Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName: String
    private lateinit var sAccountNo: String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_details)

        auth = Firebase.auth
        database = Firebase.database.reference

        Name = findViewById(R.id.editTextTextPersonName2)
        AccountNo = findViewById(R.id.editTextNumber2)
        btnPay = findViewById(R.id.btnPay)

        btnPay.setOnClickListener {

            saveData()
            updateUI()
        }

        val btn6: Button = findViewById<Button>(R.id.btnBack3)
        btn6.setOnClickListener {
            val intent = Intent(this@cardDetails, payment2::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun saveData() {
        sName = Name.text.toString().trim()
        sAccountNo = AccountNo.text.toString().trim()

        database = FirebaseDatabase.getInstance().getReference("cardDetails")
        val details3 = details3(sName, sAccountNo)
        database.child(sName).setValue(details3).addOnSuccessListener {

            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@cardDetails, confirmation::class.java)
        startActivity(intent)
        finish()
    }
}