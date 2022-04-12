package com.example.foodapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.base.BaseRecyclerAdapter
import com.example.foodapp.view.holder.CategoryHolder

class CategoryAdapter : BaseRecyclerAdapter<CategoryData>() {
    override fun getViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return CategoryHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    fun setData(data: List<CategoryData>){
        update(data)
    }
}