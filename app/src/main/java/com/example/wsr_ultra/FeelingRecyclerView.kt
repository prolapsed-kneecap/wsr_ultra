package com.example.wsr_ultra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wsr.RetrofitClient
import com.google.android.material.card.MaterialCardView
import retrofit2.Call
import retrofit2.Response

class FeelingRecyclerView : RecyclerView.Adapter<FeelingRecyclerView.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBing(position: Int) {
//            itemView.findViewById<TextView>(R.id.feelingNameTextView).text = data.feelings[position].first
            itemView.findViewById<ImageView>(R.id.imageViewFeeling).setImageResource(data.feelings[position].second)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.feeling_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.feelings.size

    override fun onBindViewHolder(holder: FeelingRecyclerView.MyViewHolder, position: Int) {
        holder.onBing(position)
    }
}
