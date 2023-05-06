package com.example.welcom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class signup: Activity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var typeEditText: EditText
    private lateinit var signupButton: Button
    private lateinit var auth: FirebaseAuth

    private lateinit var email:String
    private lateinit var password:String
    private lateinit var name:String
    private lateinit var type:String
    private lateinit var database: DatabaseReference
// ...


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        emailEditText = findViewById(R.id.editTextTextPersonName2)
        passwordEditText = findViewById(R.id.editTextTextPersonName234)
        nameEditText =findViewById(R.id.editTextTextPersonName3)
        typeEditText= findViewById(R.id.editTextTextPersonName4)
        signupButton = findViewById(R.id.button3)

        auth = Firebase.auth
        database = Firebase.database.reference
        signupButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        saveData()
                        Toast.makeText(this, "Signup success!", Toast.LENGTH_SHORT).show()
                        updateUI(user)
                    } else {
                        Toast.makeText(this, "Signup failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun saveData() {
        email = emailEditText.text.toString().trim()
        password=passwordEditText.text.toString().trim()
        name=nameEditText.text.toString().trim()
        type=typeEditText.text.toString().trim()

        val user = Usermodel(name,type,email,password)

        val userID=FirebaseAuth.getInstance().currentUser!!.uid

        database.child("User").child(userID).setValue(user)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Login_e::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}