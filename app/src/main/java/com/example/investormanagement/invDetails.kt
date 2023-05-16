package com.example.investormanagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.investormanagement.databinding.InvDetailsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class invDetails: Activity() {

    private lateinit var binding: InvDetailsBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = InvDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {

            val name : String = binding.editTextTextPersonName3.text.toString()
            if  (name.isNotEmpty()){

                readData(name)

            }else{
                Toast.makeText(this,"Please enter the Entrepreneur Name",Toast.LENGTH_SHORT).show()
                }
            }

        binding.button.setOnClickListener{
            val name : String = binding.editTextTextPersonName3.text.toString()
            if(name.isNotEmpty()){
                deleteData(name)
            }else{
                Toast.makeText(this,"PLease enter the Entrepreneur Name",Toast.LENGTH_SHORT).show()
                }
            }

        val btn4: Button = findViewById<Button>(R.id.btnBack3)
        btn4.setOnClickListener {
            val intent = Intent(this@invDetails, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



    private fun readData(name: String) {

        database = FirebaseDatabase.getInstance().getReference("payment")
        database.child(name).get().addOnSuccessListener {

            if (it.exists()){

                val name = it.child("name").value
                val type = it.child("type").value
                val phone = it.child("phone").value
                val email = it.child("email").value
                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.editTextTextPersonName3.text.clear()
                binding.textView.text = name.toString()
                binding.textView2.text = type.toString()
                binding.textView3.text = phone.toString()
                binding.textView4.text = email.toString()

            }else{
                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteData(name: String) {

        database = FirebaseDatabase.getInstance().getReference("payment")
        database.child(name).removeValue().addOnSuccessListener{

            binding.editTextTextPersonName3.text.clear()
            Toast.makeText(this,"Successfully Deleted",Toast.LENGTH_SHORT).show()

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}