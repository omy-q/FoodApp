package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.base.Binder

class CategoryHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root), Binder<CategoryData> {
    override fun bind(data: CategoryData) {
        binding.categoryView
    }
}