package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database


class new_dealActivity :AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvID:TextView
    private lateinit var tvAddress:TextView
    private lateinit var tvPhone:TextView
    private lateinit var tvIName:TextView
    private lateinit var tvIID:TextView
    private lateinit var tvDate: TextView
    private lateinit var button3:Button

    private lateinit var auth: FirebaseAuth

    private lateinit var sName:String
    private lateinit var sID:String
    private lateinit var sAddress:String
    private lateinit var sPhone:String
    private lateinit var sIName:String
    private lateinit var sIID:String
    private lateinit var sDate :String
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_deal)

        //Initialize Firebase Auth
         auth = Firebase.auth
        database = Firebase.database.reference
        tvName = findViewById(R.id.editText1)
        tvID = findViewById(R.id.editText2)
        tvAddress = findViewById(R.id.editText3)
        tvPhone = findViewById(R.id.editText4)
        tvIName =  findViewById(R.id.editText6)
        tvIID = findViewById(R.id.editText7)
        tvDate = findViewById(R.id.editText8)
        button3 = findViewById(R.id.button3)


        button3.setOnClickListener {
            saveData()
            updateUI()
        }


        val btn8: Button = findViewById<Button>(R.id.button16)
        btn8.setOnClickListener {
            val intent = Intent(this@new_dealActivity, dealActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun saveData() {
        sName = tvName.text.toString().trim()
        sID = tvID.text.toString().trim()
        sAddress = tvAddress.text.toString().trim()
        sPhone = tvPhone.text.toString().trim()
        sIName = tvIName.text.toString().trim()
        sIID = tvIID.text.toString().trim()
        sDate = tvDate.text.toString().trim()


        database = FirebaseDatabase.getInstance().getReference("Deals")
        val deal = Deal(sName,sID,sAddress,sPhone,sIName,sIID,sDate)

        // Get a reference to the "checkboxes" child node in the database
        val checkboxesRef = database.child(sName).child("checkboxes")

        // Check if each checkbox is selected, and if so, save its value to the database
        if (findViewById<CheckBox>(R.id.checkBox).isChecked) {
            checkboxesRef.child("jewellery_maker").setValue(true)
        }
        if (findViewById<CheckBox>(R.id.checkBox2).isChecked) {
            checkboxesRef.child("fabric_design").setValue(true)
        }
        if (findViewById<CheckBox>(R.id.checkBox3).isChecked) {
            checkboxesRef.child("household_design").setValue(true)
        }
        if (findViewById<CheckBox>(R.id.checkBox4).isChecked) {
            checkboxesRef.child("event_planning").setValue(true)
        }
        if (findViewById<CheckBox>(R.id.checkBox5).isChecked) {
            checkboxesRef.child("electronic_repair").setValue(true)
        }
        if (findViewById<CheckBox>(R.id.checkBox6).isChecked) {
            checkboxesRef.child("dog_walking").setValue(true)
        }

        database.child(sName).setValue(deal).addOnSuccessListener {

            Toast.makeText(this,"Successfully saved",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI() {
        val intent = Intent(this@new_dealActivity, successActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}