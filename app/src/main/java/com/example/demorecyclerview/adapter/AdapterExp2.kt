package com.example.demorecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.R
import com.example.demorecyclerview.model.Object2

class AdapterExp2(private var listData: MutableList<Object2>) :
    RecyclerView.Adapter<AdapterExp2.ViewHolder2>() {
    class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView: ImageView = itemView.findViewById(R.id.iv_avatar)
        var textView: TextView = itemView.findViewById(R.id.tv_text_vertical)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_vertical, parent, false)
        return ViewHolder2(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.textView.text = listData[position].string
        holder.imgView.setImageResource(listData[position].resourceId)
    }
}