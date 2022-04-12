package com.example.foodapp.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemBannerBinding
import com.example.foodapp.model.data.BannerData
import com.example.foodapp.view.base.Binder

class BannerHolder(private val binding: ItemBannerBinding) :
    RecyclerView.ViewHolder(binding.root), Binder<BannerData> {
    override fun bind(data: BannerData) {
        binding.bannerImageView
    }
}