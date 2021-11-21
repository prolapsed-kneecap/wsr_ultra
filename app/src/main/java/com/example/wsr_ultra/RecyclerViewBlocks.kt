package com.example.wsr_ultra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlockRecyclerView : RecyclerView.Adapter<BlockRecyclerView.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBing(position: Int) {
            itemView.findViewById<TextView>(R.id.textView11).text = data.blocks[position].first
            itemView.findViewById<TextView>(R.id.textView12).text = data.blocks[position].second
            itemView.findViewById<ImageView>(R.id.imageViewBlock).setImageResource(data.descToImage[data.blocks[position].second]!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.block_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.blocks.size

    override fun onBindViewHolder(holder: BlockRecyclerView.MyViewHolder, position: Int) {
        holder.onBing(position)
    }
}