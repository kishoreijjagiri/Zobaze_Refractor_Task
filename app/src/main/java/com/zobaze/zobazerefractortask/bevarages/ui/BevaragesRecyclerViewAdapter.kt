package com.zobaze.zobazerefractortask.bevarages.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zobaze.zobazerefractortask.R
import com.zobaze.zobazerefractortask.bevarages.data.dto.BeersAleResponseItem


class BevaragesRecyclerViewAdapter(
    private val values: List<BeersAleResponseItem>
) : RecyclerView.Adapter<BevaragesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater =LayoutInflater.from(parent.context).inflate(R.layout.beverage_list_item,parent,false)
        return ViewHolder(layoutInflater.rootView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.id.text = item.id.toString()
        holder.name.text = item.name
        holder.price_tv.text="Price : ${item.price}"
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        val id: TextView = binding.findViewById(R.id.id)
        val name: TextView = binding.findViewById(R.id.name)
        val price_tv :TextView=binding.findViewById(R.id.price)
    }

}