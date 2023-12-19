package com.therishideveloper.smartbera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.therishideveloper.smartbera.databinding.ItemMainMenuBinding

/**
 * Created by Shuva Ranjan Rishi on 13,April,2023
 * BABL, Bangladesh,
 */

class MainMenuAdapter(private val onNoteClicked: (MainMenu) -> Unit) :
    ListAdapter<MainMenu, MainMenuAdapter.MainMenuViewHolder>(ComparatorDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuViewHolder {
        val binding =
            ItemMainMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainMenuAdapter.MainMenuViewHolder, position: Int) {
        val note = getItem(position)
        note?.let {
            holder.bind(it)
        }
    }

    inner class MainMenuViewHolder(private val binding: ItemMainMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mainMenu: MainMenu) {
            binding.titleTv.text = mainMenu.title
            binding.iconIv.setImageResource(mainMenu.icon)
            binding.root.setOnClickListener {
                onNoteClicked(mainMenu)
            }
        }
    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<MainMenu>() {
        override fun areItemsTheSame(oldItem: MainMenu, newItem: MainMenu): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MainMenu, newItem: MainMenu): Boolean {
            return oldItem == newItem
        }
    }
}