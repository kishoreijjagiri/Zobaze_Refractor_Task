package com.zobaze.zobazerefractortask.bevarages.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zobaze.zobazerefractortask.R
import com.zobaze.zobazerefractortask.common.Response
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BevaragesActivity : AppCompatActivity() {
    private val mainViewModel: BevaragesViewModel by viewModels()
    lateinit var  progressbar :ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bevarages)
        progressbar =findViewById(R.id.progressbar)
        mainViewModel.getdata()
        Log.v("kishore","actvity oncreate")

        mainViewModel.data.observe(this) {

            when(it){
                is Response.Error -> {
                    progressbar.visibility=View.GONE
                }
                is Response.Loading -> {
                    progressbar.visibility=View.VISIBLE
                }
                is Response.Success -> {
                    progressbar.visibility=View.GONE
                    var recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = it.data?.let { it1 -> BevaragesRecyclerViewAdapter(it1) }
                }
            }


        }
    }
}