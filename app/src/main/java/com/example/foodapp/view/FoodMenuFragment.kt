package com.example.foodapp.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentFoodMenuBinding
import com.example.foodapp.view.base.BaseFragment
import com.example.foodapp.view_model.AppState
import com.example.foodapp.view_model.FoodViewModel

class FoodMenuFragment : BaseFragment<FragmentFoodMenuBinding>(FragmentFoodMenuBinding::inflate) {
    private val foodAdapter = FoodMenuAdapter()
    private val categoryAdapter = CategoryAdapter()
    private val bannerAdapter = BannerAdapter()
    private val foodViewModel: FoodViewModel by lazy {
        ViewModelProvider(this).get(FoodViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodViewModel.getLiveData().observe(viewLifecycleOwner) {appState ->
            render(appState)}
        initFoodRecyclerView()
        initCategoryRecyclerView()
        initBannerRecyclerView()
        foodViewModel.init()
    }

    private fun render(appState: AppState) {
        when(appState){
            is AppState.SuccessInitData -> {
                bannerAdapter.setData(appState.bannerData)
                categoryAdapter.setData(appState.categories)
                foodViewModel.getDataOfCategory()
            }
            is AppState.SuccessFoodOfCategory -> foodAdapter.setData(appState.food)
        }
    }

    private fun initBannerRecyclerView() {
        with(binding.appBarLayout.bannerRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bannerAdapter
        }
    }

    private fun initCategoryRecyclerView() {
        with(binding.appBarLayout.categoryRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    private fun initFoodRecyclerView() {
        with(binding.foodMenuRecyclerView) {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = foodAdapter
        }
    }
}