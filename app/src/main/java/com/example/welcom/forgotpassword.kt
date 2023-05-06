package com.example.welcom

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class forgotpassword: Activity() {

    private lateinit var edtPassword:EditText
    private lateinit var btnReset:Button

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frogotpassword)

        edtPassword = findViewById(R.id.emaill)
        btnReset = findViewById(R.id.button222)

        auth = FirebaseAuth.getInstance()

        btnReset.setOnClickListener {

            val sPassword = edtPassword.text.toString()
            auth.sendPasswordResetEmail(sPassword)
                .addOnSuccessListener {
                    Toast.makeText(this, "Please Check Your Email", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }
    }
}