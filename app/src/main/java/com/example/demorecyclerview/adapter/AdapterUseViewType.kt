package com.example.demorecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.R
import com.example.demorecyclerview.model.Object2

class AdapterUseViewType(
    private var list: MutableList<Object2>, private var list2: MutableList<Object2>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewTypeViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, reSrcId: Int) {
            val imgView1: ImageView = itemView.findViewById(R.id.iv_avatar)
            val textView1: TextView = itemView.findViewById(R.id.tv_text_vertical)
            imgView1.setImageResource(reSrcId)
            textView1.text = text
        }
    }

    inner class ViewTypeViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, reSrcId: Int) {
            val imgView2: ImageView = itemView.findViewById(R.id.iv_photo)
            val textView2: TextView = itemView.findViewById(R.id.tv_name)
            imgView2.setImageResource(reSrcId)
            textView2.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.TYPE_1.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_view_vertical, parent, false)
                ViewTypeViewHolder1(view)
            }
            else -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_grid, parent, false)
                ViewTypeViewHolder2(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size + list2.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewTypeViewHolder1 -> holder.bind(
                list[position].string,
                list[position].resourceId
            )
            is ViewTypeViewHolder2 -> holder.bind(
                list2[position - list.size].string,
                list2[position - list.size].resourceId
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until list.size -> ViewType.TYPE_1.type
            else -> ViewType.TYPE_2.type
        }
    }

    enum class ViewType(val type: Int) {
        TYPE_1(0),
        TYPE_2(1)
    }
}