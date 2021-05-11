package com.example.demorecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.R


class AdapterExp1(private val listData: Array<String>) :
    RecyclerView.Adapter<AdapterExp1.ViewHolder1>() {

    class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_text_horizontal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_horizontal, parent, false)
        return ViewHolder1(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.textView.text = listData[position]
    }
}