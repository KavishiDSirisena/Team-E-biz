package com.example.investormanagement

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.investormanagement.databinding.UpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class update: AppCompatActivity() {

    private lateinit var binding : UpdateBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {

            val name = binding.editTextTextPersonName5.text.toString()
            val phone = binding.editTextTextPersonName6.text.toString()
            val email = binding.editTextTextPersonName7.text.toString()

            updateData(name,phone,email)

        }

    }

    private fun updateData(name: String, phone: String, email: String) {
        database = FirebaseDatabase.getInstance().getReference("payment")
        val payment = mapOf<String,String>(
            "name" to name,
            "phone" to phone,
            "email" to email
        )

        database.child(name).updateChildren(payment).addOnSuccessListener {

            binding.editTextTextPersonName5.text.clear()
            binding.editTextTextPersonName6.text.clear()
            binding.editTextTextPersonName7.text.clear()
            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{

            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

            }
        }

}