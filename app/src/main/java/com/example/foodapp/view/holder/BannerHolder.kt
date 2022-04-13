package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.databinding.ItemBannerBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.base.Binder

class BannerHolder(private val binding: ItemBannerBinding) :
    RecyclerView.ViewHolder(binding.root), Binder<CategoryData> {
    override fun bind(data: CategoryData) {
        binding.bannerImageView.load(data.categoryBanner)
    }
}