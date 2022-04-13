package com.example.foodapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.base.BaseRecyclerAdapter
import com.example.foodapp.view.holder.CategoryHolder

class CategoryAdapter(private val categoryClickListener: CategoryClickListener) :
    BaseRecyclerAdapter<CategoryData>() {
    private var currentCheckedItemPosition: Int = 0
    private val chipClickListener = object : ChipClickListener {
        override fun onClick(oldItemCheckedPosition: Int, newItemCheckedPosition: Int) {
            currentCheckedItemPosition = newItemCheckedPosition
            notifyItemChanged(oldItemCheckedPosition)
            notifyItemChanged(newItemCheckedPosition)
        }
    }

    override fun getViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return CategoryHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            ), categoryClickListener,
            chipClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryHolder).bind(
            getDataPosition(position),
            currentCheckedItemPosition,
            position
        )
    }

    fun updateData(data: List<CategoryData>) {
        update(data)
        notifyDataSetChanged()
    }

    fun getInitCategory(): CategoryData {
        return getDataPosition(currentCheckedItemPosition)
    }
}