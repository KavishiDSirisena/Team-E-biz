package com.example.profile.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.profile.R
import com.example.profile.model.FeedbackModel

import com.google.firebase.database.FirebaseDatabase

class FeedbackDetailsActivity: AppCompatActivity () {

    private lateinit var tvfeedId: TextView
    private lateinit var tvFeedName: TextView
    private lateinit var tvFeedDes: TextView
    private lateinit var btnEdit: Button
    private lateinit var btnDelete:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_feedbackkk)

        initView()
        setValuesToViews()

        btnEdit.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("feedId").toString(),
                intent.getStringExtra("FeedName").toString()

            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("feedId").toString()
            )
        }
    }

    private fun deleteRecord(
        id:String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("FeedData").child(id)
        val mdelete = dbRef.removeValue()

        mdelete.addOnSuccessListener {
            Toast.makeText(this,"Feedback deleted successfully",Toast.LENGTH_LONG).show()
            val intent = Intent(this,Optionsclz::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this,"Deleting Err ${error.message}",Toast.LENGTH_LONG).show()

        }
    }

    private fun initView() {
        tvfeedId=findViewById(R.id.viewId)
        tvFeedName =findViewById(R.id.viewName)
        tvFeedDes=findViewById(R.id.viewfeedDes)

    }

    private fun setValuesToViews()
    {

        tvfeedId.text = intent.getStringExtra("feedId")
        tvFeedName .text =intent.getStringExtra("FeedName")
        tvFeedDes.text =intent.getStringExtra("FeedDes")



    }

    @SuppressLint("MissingInflatedId")
    private fun openUpdateDialog(
        feedId:String,
        feedName:String
    ){
        val myDialog =AlertDialog.Builder(this)
        val inflater =layoutInflater
        val myDialogView = inflater.inflate(R.layout.update_feedback,null)

        myDialog.setView(myDialogView)

        val feedName = myDialogView.findViewById<EditText>(R.id.textViewtitle)
        val feedDes = myDialogView.findViewById<EditText>(R.id.textViewcategory)
        val btnUpdate = myDialogView.findViewById<Button>(R.id.buttonuupdate)

        feedName.setText(intent.getStringExtra("FeedName").toString())
        feedDes.setText(intent.getStringExtra("FeedDes").toString())


        myDialog.setTitle("Update your feedback")

        val alertDialog = myDialog.create()
        alertDialog.show()

        btnUpdate.setOnClickListener {
            updateGigData(
                feedId,
                feedName.text.toString(),
                feedDes.text.toString(),

            )
            Toast.makeText(applicationContext,"Feedback updated successfully !",Toast.LENGTH_LONG).show()
            // we are setting updated data to text views
            tvFeedName.text = feedName.text.toString()
            tvFeedDes.text =feedDes.text.toString()


            alertDialog.dismiss()
        }




    }

    private fun updateGigData(
        id:String,
        name:String,
        des: String,

    ){
        val dbRef =FirebaseDatabase.getInstance().getReference("FeedData").child(id)
        val feedInfo = FeedbackModel(id,name,des)

        dbRef.setValue(feedInfo)

    }



}