package com.example.foodapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemFoodMenuBinding
import com.example.foodapp.model.data.FoodData
import com.example.foodapp.view.holder.Binder
import com.example.foodapp.view.holder.FoodMenuHolder

class FoodMenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data: MutableList<FoodData> = mutableListOf()

    fun update(data: List<FoodData>) {
        this.data.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodMenuHolder(
            ItemFoodMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder).bind(data[position])
    }

    override fun getItemCount() = data.size
}