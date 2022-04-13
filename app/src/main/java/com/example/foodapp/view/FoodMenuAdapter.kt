package com.example.foodapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemFoodMenuBinding
import com.example.foodapp.model.data.FoodData
import com.example.foodapp.view.base.BaseRecyclerAdapter
import com.example.foodapp.view.holder.FoodMenuHolder

class FoodMenuAdapter : BaseRecyclerAdapter<FoodData>() {
    override fun getViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return FoodMenuHolder(
            ItemFoodMenuBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    fun setFoodData(data: List<FoodData>){
        setNewData(data)
        notifyDataSetChanged()
    }
}