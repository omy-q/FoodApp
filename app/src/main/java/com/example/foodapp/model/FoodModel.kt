package com.example.foodapp.model

import com.example.foodapp.model.data.BannerData
import com.example.foodapp.model.data.CategoryData
import com.example.foodapp.model.data.FoodData
import io.reactivex.rxjava3.core.Single

interface FoodModel {
    fun getFoodCategories(): Single<List<CategoryData>>
    fun getFoodMenuOfCategory(category: CategoryData): Single<List<FoodData>>
    fun getBanners(): Single<List<BannerData>>
}