package com.example.foodapp.model

import com.example.foodapp.model.data.*
import io.reactivex.rxjava3.core.Single

class FoodModelImplementation(
    private val remoteSource: RemoteApi
): FoodModel {
    override fun getFoodCategories(): Single<ApiCategoryAnswer> {
        return remoteSource.getCategories()
    }

    override fun getFoodMenuOfCategory(category: CategoryData): Single<ApiFoodDataAnswer> {
        return remoteSource.getFoodOfCategory(category.category)
    }
}