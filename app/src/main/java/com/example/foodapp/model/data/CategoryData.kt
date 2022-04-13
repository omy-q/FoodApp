package com.example.foodapp.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryData(
    @Expose
    @SerializedName("strCategory")
    val category: String,
    @Expose
    @SerializedName("strCategoryThumb")
    val categoryBanner: String
)

