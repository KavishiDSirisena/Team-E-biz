package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dashboard.databinding.DealViewBinding
import com.example.dashboard.databinding.UpdateDueBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class update_dueActivity : AppCompatActivity() {

    private lateinit var binding : UpdateDueBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdateDueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button30.setOnClickListener {

            val name = binding.head9.text.toString()
            val status = binding.head10.text.toString()
            val percentage = binding.head12.text.toString()

            updateData(name,status,percentage)

        }

        val btn19: Button = findViewById<Button>(R.id.button29)
        btn19.setOnClickListener {
            val intent = Intent(this@update_dueActivity,dealActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateData(name: String, status: String, percentage: String) {
        database = FirebaseDatabase.getInstance().getReference("Due Diligence")
        val due = mapOf<String,String>(
            "name" to name,
            "status" to status,
            "percentage" to percentage
        )

        database.child(name).updateChildren(due).addOnSuccessListener {

            binding.head9.text.clear()
            binding.head10.text.clear()
            binding.head12.text.clear()
            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{

            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()

        }
    }
}