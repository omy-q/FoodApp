package com.example.foodapp.model

import com.example.foodapp.model.data.ApiCategoryAnswer
import com.example.foodapp.model.data.ApiFoodDataAnswer
import com.example.foodapp.model.data.FoodData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApi {

    @GET("/api/json/v1/1/categories.php")
    fun getCategories(): Single<ApiCategoryAnswer>

    @GET("/api/json/v1/1/filter.php")
    fun getFoodOfCategory(@Query("c") category: String): Single<ApiFoodDataAnswer>
}