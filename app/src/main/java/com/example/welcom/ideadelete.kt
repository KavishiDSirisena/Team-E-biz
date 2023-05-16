package com.example.welcom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.welcom.databinding.ActivityIdeadeleteBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ideadelete: Activity() {
    private lateinit var binding: ActivityIdeadeleteBinding
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdeadeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewbutton6.setOnClickListener {
            val idea: String = binding.editdelete.text.toString()
            if (idea.isNotEmpty()) {
                readData(idea)
            } else {
                Toast.makeText(this, "PLease enter the Idea id", Toast.LENGTH_SHORT).show()
            }
        }

        binding.deletebutton5.setOnClickListener {
            val idea: String = binding.editdelete.text.toString()
            if (idea.isNotEmpty()) {
                deleteData(idea)
                updateUI()
            } else {
                Toast.makeText(this, "PLease enter the Idea id", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun updateUI() {
        val intent = Intent(this@ideadelete,contact_us::class.java)
        startActivity(intent)
        finish()
    }

    private fun readData(idea: String) {
        database = FirebaseDatabase.getInstance().getReference("Idea")
        database.child(idea).get().addOnSuccessListener {
            if (it.exists()) {

                val idea = it.child("idea").value
                val userid = it.child("userid").value
                val details = it.child("details").value


                Toast.makeText(this, "Successfully Read", Toast.LENGTH_SHORT).show()
                binding.editdelete.text.clear()
                binding.text13.text = idea.toString()
                binding.text14.text = userid.toString()
                binding.text15.text = details.toString()


            } else {

                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener {

            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()


        }
    }

    private fun deleteData(idea: String) {
        database = FirebaseDatabase.getInstance().getReference("Idea")
        database.child(idea).removeValue().addOnSuccessListener {

            binding.editdelete.text.clear()
            Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

        }

    }

}