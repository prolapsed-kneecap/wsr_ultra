package com.example.wsr_ultra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBing(position: Int) {
            itemView.findViewById<TextView>(R.id.timeTextView).text = data.images[position]
            val imageView = itemView.findViewById<ImageView>(R.id.imageImageView)
            when(position){
                0 -> {imageView.setImageResource(R.drawable.image1)}
                1 -> {imageView.setImageResource(R.drawable.image2)}
                2 -> {imageView.setImageResource(R.drawable.image3)}
                3 -> {imageView.setImageResource(R.drawable.image4)}
                4 -> {imageView.setImageResource(R.drawable.plus); imageView.setBackgroundResource(R.color.add_button)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBing(position)
    }

    override fun getItemCount(): Int = data.images.size
}
