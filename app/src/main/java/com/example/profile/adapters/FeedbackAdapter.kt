package com.example.profile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profile.R
import com.example.profile.model.FeedbackModel

class FeedbackAdapter(private  val gigList:ArrayList<FeedbackModel>): RecyclerView.Adapter<FeedbackAdapter.ViewHolder>(){

    private lateinit var myListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(clickListner: onItemClickListner){
        myListner =clickListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.feedback_list_item,parent,false)
        return ViewHolder(itemView,myListner)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val currentGig = gigList[position]
        holder.tvFeedName.text = currentGig.FeedName
    }


    override fun getItemCount(): Int {
        return gigList.size
    }

    class ViewHolder( itemView: View,clickListner: onItemClickListner): RecyclerView.ViewHolder(itemView) {
        val tvFeedName: TextView = itemView.findViewById(R.id.tvFeedName)

        init {
            itemView.setOnClickListener {
                clickListner.onItemClick(adapterPosition)
            }
        }
    }

}