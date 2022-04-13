package com.example.foodapp.view_model

import com.example.foodapp.model.data.BannerData
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.model.data.FoodData

sealed class AppState {
    data class SuccessInitData(val categories: List<CategoryData>) : AppState()
    data class SuccessFoodOfCategory (val food: List<FoodData>): AppState()
    data class Error(val error: Throwable): AppState()
}