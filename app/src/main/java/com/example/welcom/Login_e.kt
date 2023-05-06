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
import com.google.firebase.ktx.Firebase

class Login_e : Activity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var regbutton: Button
    private lateinit var resetbutton: Button
    private lateinit var loginButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        emailEditText = findViewById(R.id.editTextTextPersonName)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.button66)



        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                        updateUI(user)
                    } else {
                        Toast.makeText(this,
                            "Login failed: ${task.exception?.message}",
                            Toast.LENGTH_SHORT).show()
                    }
                }

        }
        regbutton = findViewById(R.id.button2343)
        regbutton.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        resetbutton = findViewById(R.id.forgot1)
        resetbutton.setOnClickListener {
            val intent = Intent(this, forgotpassword::class.java)
            startActivity(intent)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Idea::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}