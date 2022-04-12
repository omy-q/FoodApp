package com.example.foodapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemBannerBinding
import com.example.foodapp.model.data.BannerData
import com.example.foodapp.view.base.BaseRecyclerAdapter
import com.example.foodapp.view.holder.BannerHolder

class BannerAdapter : BaseRecyclerAdapter<BannerData>() {
    override fun getViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder {
        return BannerHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    fun setData(data: List<BannerData>){
        update(data)
    }
}