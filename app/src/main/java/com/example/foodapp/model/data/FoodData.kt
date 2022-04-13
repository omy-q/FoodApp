package com.example.foodapp.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FoodData(
    @Expose
    @SerializedName("idMeal")
    val foodId: Int,
    @Expose
    @SerializedName("strMeal")
    val foodName: String,
    val foodDescription: String,
    @Expose
    @SerializedName("strMealThumb")
    val foodImage: String,
) {
    val foodPrice: Int
        get() = foodId.div(100)
}

data class ApiFoodDataAnswer(
    @Expose
    @SerializedName("meals")
    val foodData: List<FoodData>
)