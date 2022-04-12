package com.example.foodapp.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentFoodMenuBinding
import com.example.foodapp.model.data.testBannerData
import com.example.foodapp.model.data.testCategoryData
import com.example.foodapp.model.data.testFoodData
import com.example.foodapp.view.base.BaseFragment

class FoodMenuFragment : BaseFragment<FragmentFoodMenuBinding>(FragmentFoodMenuBinding::inflate) {
    private val foodAdapter = FoodMenuAdapter()
    private val categoryAdapter = CategoryAdapter()
    private val bannerAdapter = BannerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFoodRecyclerView()
        initCategoryRecyclerView()
        initBannerRecyclerView()
    }

    private fun initBannerRecyclerView() {
        with(binding.appBarLayout.bannerRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bannerAdapter
        }
        bannerAdapter.setData(testBannerData)
    }

    private fun initCategoryRecyclerView() {
        with(binding.appBarLayout.categoryRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
        categoryAdapter.setData(testCategoryData)
    }

    private fun initFoodRecyclerView() {
        with(binding.foodMenuRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = foodAdapter
        }
        foodAdapter.setData(testFoodData)
    }
}