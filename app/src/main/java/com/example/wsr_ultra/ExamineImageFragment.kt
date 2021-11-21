package com.example.wsr_ultra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController


class ExamineImageFragment : Fragment()  {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_examine_image, container, false)

        var pos = arguments?.getInt("pos")?.minus(data.currentDeleted)

        view.findViewById<TextView>(R.id.textViewCancel).setOnClickListener {
            view.findNavController().navigate(R.id.action_examineImageFragment_to_profileFragment)
        }
        view.findViewById<TextView>(R.id.textViewDelete).setOnClickListener {
            data.imageDrawables.removeAt(pos!!)
            data.images.remove(pos)
            data.currentDeleted++
            view.findNavController().navigate(R.id.action_examineImageFragment_to_profileFragment)
        }
        if (pos != 4){
            view.findViewById<ImageView>(R.id.ImageViewRemoveImage).setImageResource(data.imageDrawables[pos!!]-data.currentDeleted)
        }

        return view
    }
}