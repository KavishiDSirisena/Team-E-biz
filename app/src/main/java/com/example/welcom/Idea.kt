package com.example.welcom

import android.app.Activity
import android.content.Intent
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

class Idea: Activity() {
    private lateinit var tvidea: TextView
    private lateinit var tvuserid:TextView
    private lateinit var tvdetails:TextView
    private lateinit var button3:Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sidea:String
    private lateinit var suserid:String
    private lateinit var sdetails:String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea)
       //Initialize Firebase Auth
        auth = Firebase.auth
        database = Firebase.database.reference

        tvidea = findViewById(R.id.editidea)
        tvuserid= findViewById(R.id.editide)
        tvdetails = findViewById(R.id.idea)
        button3 = findViewById(R.id.button234567)

        button3.setOnClickListener {
            saveData()
            updateUI()
        }
        val btn9: Button = findViewById<Button>(R.id.editbut)
        btn9.setOnClickListener {
            val intent = Intent(this@Idea,ideadelete::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@Idea, dash::class.java)
        startActivity(intent)
        finishAffinity()
    }

    private fun saveData() {
        sidea = tvidea.text.toString().trim()
        suserid = tvuserid.text.toString().trim()
        sdetails = tvdetails.text.toString().trim()

        database = FirebaseDatabase.getInstance().getReference("Idea")
        val ideaaa = Ideaaa(sidea,suserid,sdetails)

        database.child(sidea).setValue(ideaaa).addOnSuccessListener {

            Toast.makeText(this,"Successfully saved",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}