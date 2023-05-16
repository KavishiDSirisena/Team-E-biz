package com.example.welcom

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class contact_us : Activity() {
        private lateinit var tvPnum: TextView
        private lateinit var tvMessage: TextView
        private lateinit var button44: Button

        private lateinit var auth: FirebaseAuth

        private lateinit var spnum: String
        private lateinit var smessage: String
        private lateinit var database: DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_contact_us)

            //Initialize Firebase Auth
            auth = Firebase.auth
            database = Firebase.database.reference

            tvPnum = findViewById(R.id.editText2322)
            tvMessage= findViewById(R.id.editText5655)
            button44 = findViewById(R.id.button123)

            button44.setOnClickListener {
                saveData()
            }
        }

        private fun saveData() {
            spnum = tvPnum.text.toString().trim()
            smessage = tvMessage.text.toString().trim()

            database = FirebaseDatabase.getInstance().getReference("contact")
            val contactt = Ideaaa(spnum,smessage)

            database.child(spnum).setValue(contactt).addOnSuccessListener {

                Toast.makeText(this,"Successfully saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
