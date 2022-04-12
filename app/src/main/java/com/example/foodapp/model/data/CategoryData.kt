package com.example.foodapp.model.data

data class CategoryData(
    val category: String
)

val testCategoryData = mutableListOf<CategoryData>(
    CategoryData("десерты"),
    CategoryData("горячме блюда"),
    CategoryData("супы")
)
