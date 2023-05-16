package com.example.profile.activities


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profile.R
import com.example.profile.model.FeedbackModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FeedbckInsert : AppCompatActivity() {

    private lateinit var btnInsert: Button
    private lateinit var feedbackName:EditText
    private lateinit var  feedbackDes:EditText

    private lateinit var dbRef:DatabaseReference

    //    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedback)

        feedbackName = findViewById(R.id.viewName)
        feedbackDes=findViewById(R.id.viewfeedDes)
        btnInsert=findViewById(R.id.btnSubmit)

        dbRef = FirebaseDatabase.getInstance().getReference("FeedData")

        btnInsert.setOnClickListener {
            saveGigData()
        }



    }

    private fun saveGigData() {

        val feedbackName1 = feedbackName.text.toString()
        val feedbackDes1 = feedbackDes.text.toString()
        var isFormValid = true

        if (feedbackDes1.isEmpty()) {
            feedbackDes.error = "Please enter the gig title"
            return
        }

        if (feedbackName1.isEmpty()) {
            feedbackName.error = "Please enter the gig Description"
            return
        }

        val gigId = dbRef.push().key!!
        val gig = FeedbackModel(gigId, feedbackName1, feedbackDes1)

        if (isFormValid) {
            dbRef.child(gigId).setValue(gig)
                .addOnCompleteListener {
                    Toast.makeText(this, "Your feedback added successfully", Toast.LENGTH_LONG)
                        .show()

                    feedbackName.text.clear()
                    feedbackDes.text.clear()

                    val intent = Intent(this@FeedbckInsert, Optionsclz::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }
        }
    }

}
