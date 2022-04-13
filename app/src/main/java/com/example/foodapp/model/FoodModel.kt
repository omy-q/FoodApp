package com.example.foodapp.model

import com.example.foodapp.model.data.ApiCategoryAnswer
import com.example.foodapp.model.data.ApiFoodDataAnswer
import com.example.foodapp.model.data.CategoryData
import io.reactivex.rxjava3.core.Single

interface FoodModel {
    fun getFoodCategories(): Single<ApiCategoryAnswer>
    fun getFoodMenuOfCategory(category: CategoryData): Single<ApiFoodDataAnswer>
}