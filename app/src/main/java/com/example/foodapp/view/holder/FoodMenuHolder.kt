package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.foodapp.databinding.ItemFoodMenuBinding
import com.example.foodapp.model.data.FoodData
import com.example.foodapp.view.base.Binder

class FoodMenuHolder(private val binding: ItemFoodMenuBinding) : RecyclerView.ViewHolder(binding.root),
    Binder<FoodData> {
    override fun bind(data: FoodData) {
        binding.foodName.text = data.foodName
        binding.foodDescription.text = "No description"
        binding.foodImage.load(data.foodImage){
            transformations(CircleCropTransformation())
        }
        binding.foodPrice.text = "from ${data.foodPrice.toString()} rubles"
    }
}