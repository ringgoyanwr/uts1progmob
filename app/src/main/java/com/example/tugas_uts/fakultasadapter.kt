package com.example.tugas_uts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fakultas_list_item.view.*

class fakultasadapter (val fakultasItemList : List<FakultasData>, val clickListener: (FakultasData) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view = inflater.inflate(R.layout.fakultas_list_item, parent, false)
    return PartViewHolder(view)
}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(fakultasItemList[position], clickListener)
    }

    override fun getItemCount() = fakultasItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fakultas: FakultasData, clickListener: (FakultasData) -> Unit) {
            itemView.textView4.text = fakultas.fakultas.toString()
            itemView.imageView.setImageResource(R.drawable.logo)

            itemView.setOnClickListener { clickListener(fakultas) }
        }
    }
}
