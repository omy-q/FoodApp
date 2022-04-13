package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.CategoryClickListener
import com.example.foodapp.view.ChipClickListener

class CategoryHolder(
    private val binding: ItemCategoryBinding,
    private val listener: CategoryClickListener,
    private val chipClickListener: ChipClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CategoryData, itemCheckedPosition: Int, currentPosition: Int) {
        binding.categoryView.text = data.category
        binding.categoryView.isChecked = itemCheckedPosition == currentPosition
        binding.categoryView.setOnClickListener {
                chipClickListener.onClick(itemCheckedPosition, currentPosition)
                listener.onClick(data)
        }

    }
}