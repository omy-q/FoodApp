package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.CategoryClickListener
import com.example.foodapp.view.ChipClickListener
import com.example.foodapp.view.base.Binder

class CategoryHolder(
    private val binding: ItemCategoryBinding,
    private val listener: CategoryClickListener,
    private val chipClickListener: ChipClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CategoryData, itemCheckedPosition: Int, currentPosition: Int) {
        if (itemCheckedPosition == currentPosition) {
            binding.categoryView.isChecked = true
            binding.categoryView.setTextAppearance(R.style.ActiveItemCategoryTextAppearance)
        } else {
            binding.categoryView.setTextAppearance(R.style.DisableItemCategoryTextAppearance)
        }
        binding.categoryView.text = data.category
        binding.categoryView.setOnClickListener {
            if (!binding.categoryView.isChecked) {
                chipClickListener.onClick(itemCheckedPosition, currentPosition)
                listener.onClick(data)
            }
        }
    }
}