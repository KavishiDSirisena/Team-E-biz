package com.example.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.dashboard.databinding.DealViewBinding
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class deal_viewActivity : AppCompatActivity() {

    private lateinit var binding : DealViewBinding
    private lateinit var database : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DealViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button19.setOnClickListener{
            val name : String = binding.editText9.text.toString()
            if(name.isNotEmpty()){
                readData(name)
            }else{
                Toast.makeText(this,"PLease enter the Entrepreneur Name",Toast.LENGTH_SHORT).show()
            }
        }

        binding.button40.setOnClickListener{
            val name : String = binding.editText9.text.toString()
            if(name.isNotEmpty()){
                deleteData(name)
            }else{
                Toast.makeText(this,"PLease enter the Entrepreneur Name",Toast.LENGTH_SHORT).show()
            }
        }

        val btn12: Button = findViewById<Button>(R.id.button20)
        btn12.setOnClickListener {
            val intent = Intent(this@deal_viewActivity, dealActivity::class.java)
            startActivity(intent)
            finish()

        }
    }


    private fun readData(name: String) {
        database = FirebaseDatabase.getInstance().getReference("Deals")
        database.child(name).get().addOnSuccessListener {
            if (it.exists()){

                val id = it.child("id").value
                val iname = it.child("iname").value
                val iid = it.child("iid").value
                val date = it.child("date").value

                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.editText9.text.clear()
                binding.textView2.text = id.toString()
                binding.textView5.text = iname.toString()
                binding.textView3.text = iid.toString()
                binding.textView4.text = date.toString()


            }else{

                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }
        }
    private fun deleteData(name: String) {
        database = FirebaseDatabase.getInstance().getReference("Deals")
        database.child(name).removeValue().addOnSuccessListener{

            binding.editText9.text.clear()
            Toast.makeText(this,"Successfully Deleted",Toast.LENGTH_SHORT).show()

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

        }

    }
    }
