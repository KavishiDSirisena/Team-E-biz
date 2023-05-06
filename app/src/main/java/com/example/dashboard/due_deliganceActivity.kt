package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class due_deliganceActivity: AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvPercentage: TextView
    private lateinit var tvAgreement: TextView
    private lateinit var tvInvestment: TextView
    private lateinit var tvPerformance: TextView
    private lateinit var tvLegal : TextView
    private lateinit var button23:Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName:String
    private lateinit var sStatus:String
    private lateinit var sPercentage:String
    private lateinit var sAgreement:String
    private lateinit var sInvestment:String
    private lateinit var sPerformance:String
    private lateinit var sLegal:String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.due_delligance)


        //Initialize Firebase Auth
        auth = Firebase.auth
        database = Firebase.database.reference
        tvName = findViewById(R.id.head9)
        tvStatus = findViewById(R.id.head10)
        tvPercentage = findViewById(R.id.head11)
        tvAgreement = findViewById(R.id.checkBox8)
        tvInvestment =  findViewById(R.id.checkBox7)
        tvPerformance = findViewById(R.id.checkBox9)
        tvLegal = findViewById(R.id.checkBox10)
        button23 = findViewById(R.id.button23)


        button23.setOnClickListener {
            saveData()
            updateUI()
        }


        val btn18: Button = findViewById<Button>(R.id.button28)
        btn18.setOnClickListener {
            val intent = Intent(this@due_deliganceActivity, dealActivity::class.java)
            startActivity(intent)
            finish()

        }
    }



    private fun saveData() {
        sName = tvName.text.toString().trim()
        sStatus = tvStatus.text.toString().trim()
        sPercentage = tvPercentage.text.toString().trim()
        sAgreement = tvAgreement.text.toString().trim()
        sInvestment = tvInvestment.text.toString().trim()
        sPerformance = tvPerformance.text.toString().trim()
        sLegal = tvLegal.text.toString().trim()


        database = FirebaseDatabase.getInstance().getReference("Due Diligence")
        val due = Due(sName,sStatus,sPercentage,sAgreement,sInvestment,sPerformance,sLegal)
        database.child(sName).setValue(due).addOnSuccessListener {

            Toast.makeText(this,"Successfully saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI() {
        val intent = Intent(this@due_deliganceActivity, update_dueActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}