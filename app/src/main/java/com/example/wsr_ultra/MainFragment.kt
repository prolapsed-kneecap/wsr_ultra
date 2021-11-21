package com.example.wsr_ultra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class MainFragment : Fragment() {


    val stateData : MutableStateFlow<Resource<Feelings>?> = MutableStateFlow(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch() {
            stateData.value = Resource.Loading()
            val response = withContext(Dispatchers.IO) {
                Common.retrofitServices.getFeelings().execute()
            }
            if (response.isSuccessful){
                stateData.value = Resource.Success(response.body()!!)
            } else {
                stateData.value = Resource.Error(response.code().toString())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFeelings)
        recyclerView.adapter = FeelingRecyclerView()
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        val recyclerViewBlocks = view.findViewById<RecyclerView>(R.id.recyclerViewBlocks)

        recyclerViewBlocks.adapter = BlockRecyclerView()
        recyclerViewBlocks.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            stateData.collect {
                when (it){
                    is Resource.Error -> {
                        Snackbar.make(requireView(), it.message.toString(), Snackbar.LENGTH_LONG).show()
                        view.findViewById<ProgressBar>(R.id.progressbr).visibility = View.GONE

                    }
                    is Resource.Loading -> {
                        view.findViewById<ProgressBar>(R.id.progressbr).visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        view.findViewById<ProgressBar>(R.id.progressbr).visibility = View.GONE

                    }
                }
            }
        }
    }
}