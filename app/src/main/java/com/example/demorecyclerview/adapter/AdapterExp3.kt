package com.example.demorecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.R
import com.example.demorecyclerview.adapter.AdapterExp3.ViewHolder3
import com.example.demorecyclerview.model.Object2

class AdapterExp3(
    private var listData: MutableList<Object2>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ViewHolder3>() {
    inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imgView: ImageView = itemView.findViewById(R.id.iv_photo)
        var textView: TextView = itemView.findViewById(R.id.tv_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = layoutPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder3 {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_grid, parent, false)
        return ViewHolder3(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        holder.imgView.setImageResource(listData[position].resourceId)
        holder.textView.text = listData[position].string
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}