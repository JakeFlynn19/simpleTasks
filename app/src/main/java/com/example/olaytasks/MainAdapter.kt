package com.example.olaytasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.olaytasks.databinding.ViewHolderBinding

class MainAdapter(private var list: MutableList<Int>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(num: Int) {
            binding.apply {
                listItem.text = num.toString()
                listItem.setOnClickListener {
                    Toast.makeText(it.context, num.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(list[position])
    }


    override fun getItemCount() = list.size

}