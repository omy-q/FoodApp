package com.example.foodapp.model

import com.example.foodapp.model.data.BannerData
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.model.data.FoodData

interface FoodModel {
    fun getFoodCategories(): List<CategoryData>
    fun getFoodMenuOfCategory(category: CategoryData): List<FoodData>
    fun getBanners(): List<BannerData>
}