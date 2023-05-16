package com.example.profile.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profile.R
import com.example.profile.adapters.FeedbackAdapter
import com.example.profile.model.FeedbackModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FetchingActivity : AppCompatActivity() {

    private lateinit var gigRecyclerView: RecyclerView
    private lateinit var tvLoadingData:TextView
    private lateinit var gigList:ArrayList<FeedbackModel>
    private  lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)

        gigRecyclerView = findViewById(R.id.rvGig)
        gigRecyclerView.layoutManager= LinearLayoutManager(this)
        gigRecyclerView.setHasFixedSize(true)
        tvLoadingData=findViewById((R.id.tvLoadingData))

        gigList = arrayListOf<FeedbackModel>()

        getGigData()

    }

    private fun getGigData(){
        gigRecyclerView.visibility =View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef =FirebaseDatabase.getInstance().getReference("FeedData")

        //getting the data

        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                gigList.clear()
                if(snapshot.exists()){
                    for(gigSnap in snapshot.children){
                        val gigData = gigSnap.getValue(FeedbackModel::class.java)
                        gigList.add(gigData!!)
                    }
                    val myAdapter = FeedbackAdapter(gigList)
                    gigRecyclerView.adapter =myAdapter

                    myAdapter.setOnItemClickListner(object :FeedbackAdapter.onItemClickListner{
                        override fun onItemClick(position: Int){
                            val intent = Intent(this@FetchingActivity,FeedbackDetailsActivity::class.java)
                            intent.putExtra("feedId",gigList[position].feedId)
                            intent.putExtra("FeedName",gigList[position].FeedName)
                            intent.putExtra("FeedDes",gigList[position].FeedDes)
                            startActivity(intent)
                        }
                    })



                    gigRecyclerView.visibility =View.VISIBLE
                    tvLoadingData.visibility =View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

}