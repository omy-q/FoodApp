package com.example.foodapp.model

import com.example.foodapp.model.data.*
import io.reactivex.rxjava3.core.Single

class FoodModelImplementation(
    private val remoteSource: RemoteApi
): FoodModel {
    override fun getFoodCategories(): Single<List<CategoryData>> {
        return remoteSource.getCategories()
    }

    override fun getFoodMenuOfCategory(category: CategoryData): Single<List<FoodData>> {
        return remoteSource.getFoodOfCategory(category.category)
    }

    override fun getBanners(): Single<List<BannerData>> {
        return Single.fromCallable {
            testBannerData
        }
    }
}