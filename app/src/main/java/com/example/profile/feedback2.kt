package com.example.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.profile.databinding.Feedback2Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class feedback2:Activity() {
    
    private lateinit var binding: Feedback2Binding
    private lateinit var database :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Feedback2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val name : String = binding.editTextTextPersonName.toString()
            if  (name.isNotEmpty()){

                readData(name)

            }else{

                Toast.makeText(this,"Please enter your Name",Toast.LENGTH_SHORT).show()

            }

        }
        binding.button.setOnClickListener{
            val name : String = binding.editTextTextPersonName.text.toString()
            if(name.isNotEmpty()){
                deleteData(name)
            }else{
                Toast.makeText(this,"PLease enter Name",Toast.LENGTH_SHORT).show()
            }
        }

        val btn8: Button = findViewById<Button>(R.id.button3)
        btn8.setOnClickListener {
            val intent = Intent(this@feedback2, feedback::class.java)
            startActivity(intent)
            finish()
        }
    }



    private fun readData(name: String) {
        database = FirebaseDatabase.getInstance().getReference("feedback")
        database.child(name).get().addOnSuccessListener {

            if (it.exists()){

                val name = it.child("name").value
                val feedback = it.child("feedback").value
                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.editTextTextPersonName.text.clear()
                binding.textView.text = name.toString()
                binding.textView2.text = feedback.toString()


            }else{

                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }

    }
    private fun deleteData(name: String) {

    }
}