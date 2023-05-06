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


class payment: AppCompatActivity() {

    private lateinit var Name: TextView
    private lateinit var Type: TextView
    private lateinit var Phone: TextView
    private lateinit var Email: TextView

    private lateinit var btnAgreement: Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName: String
    private lateinit var sType: String
    private lateinit var sPhone: String
    private lateinit var sEmail: String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment)

        auth = Firebase.auth
        database = Firebase.database.reference

        Name = findViewById(R.id.editText1)
        Type = findViewById(R.id.editText2)
        Phone = findViewById(R.id.editText3)
        Email = findViewById(R.id.editTextTextEmailAddress)
        btnAgreement = findViewById(R.id.btnProceed)


        btnAgreement.setOnClickListener {

            saveData()
            updateUI()
        }

        val btn3: Button = findViewById<Button>(R.id.btnBack)
        btn3.setOnClickListener {
            val intent = Intent(this@payment, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun saveData() {
        sName = Name.text.toString().trim()
        sType = Type.text.toString().trim()
        sPhone = Phone.text.toString().trim()
        sEmail = Email.text.toString().trim()

        database = FirebaseDatabase.getInstance().getReference("payment")
        val details = details(sName, sType, sPhone, sEmail)
        database.child(sName).setValue(details).addOnSuccessListener {

            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@payment, payment2::class.java)
        startActivity(intent)
        finish()
    }
}
