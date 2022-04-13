package com.example.foodapp.model

import com.example.foodapp.model.data.*
import java.lang.Thread.sleep

class FoodModelImplementation: FoodModel {
    override fun getFoodCategories(): List<CategoryData> {
        sleep(200)
        return testCategoryData
    }

    override fun getFoodMenuOfCategory(category: CategoryData): List<FoodData> {
        sleep(100)
        return testFoodData
    }

    override fun getBanners(): List<BannerData> {
        sleep(1)
        return testBannerData
    }
}