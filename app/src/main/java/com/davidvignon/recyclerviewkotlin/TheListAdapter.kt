package com.davidvignon.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davidvignon.recyclerviewkotlin.data.Element
import com.davidvignon.recyclerviewkotlin.databinding.ListItemBinding

class TheListAdapter :
    ListAdapter<Element, TheListAdapter.ElementViewHolder>(ElementDiffUtilCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ElementViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ElementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ElementViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(element: Element) {
            binding.tv.text = element.text

        }
    }

    object ElementDiffUtilCallback : DiffUtil.ItemCallback<Element>() {

        override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem == newItem
        }

    }
}

