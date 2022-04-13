package com.example.foodapp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentFoodMenuBinding
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.view.base.BaseFragment
import com.example.foodapp.view_model.AppState
import com.example.foodapp.view_model.FoodViewModel

class FoodMenuFragment : BaseFragment<FragmentFoodMenuBinding>(FragmentFoodMenuBinding::inflate) {
    private val categoryClickListener = object : CategoryClickListener{
        override fun onClick(category: CategoryData) {
            foodViewModel.getDataOfCategory(category)
        }
    }
    private val foodAdapter = FoodMenuAdapter()
    private val categoryAdapter = CategoryAdapter(categoryClickListener)
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
        when (appState) {
            is AppState.SuccessInitData -> {
                bannerAdapter.updateData(appState.categories)
                categoryAdapter.updateData(appState.categories)
                foodViewModel.getDataOfCategory(categoryAdapter.getInitCategory())
            }
            is AppState.SuccessFoodOfCategory -> foodAdapter.setFoodData(appState.food)
            is AppState.Error -> setToast(appState.error)
        }
    }

    private fun setToast(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()

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