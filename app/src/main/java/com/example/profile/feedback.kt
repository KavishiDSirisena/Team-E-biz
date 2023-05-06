package com.example.profile

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

class feedback: AppCompatActivity() {

    private lateinit var Name: TextView
    private lateinit var Feedback: TextView

    private lateinit var btnSubmit: Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName: String
    private lateinit var sFeedback: String

    private lateinit var database: DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.feedback)

            auth = Firebase.auth
            database = Firebase.database.reference

            Name = findViewById(R.id.editTextTextPersonName4)
            Feedback = findViewById(R.id.feedback_input)
            btnSubmit = findViewById(R.id.btnSubmit)


            btnSubmit.setOnClickListener {

                saveData()
                updateUI()
            }

        }

    private fun saveData() {
        sName = Name.text.toString().trim()
        sFeedback = Feedback.text.toString().trim()

        database = FirebaseDatabase.getInstance().getReference("feedback")
        val details = details(sName, sFeedback)
        database.child(sName).setValue(details).addOnSuccessListener {

            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI() {
        val intent = Intent(this@feedback, feedback2::class.java)
        startActivity(intent)
        finish()
    }
}

