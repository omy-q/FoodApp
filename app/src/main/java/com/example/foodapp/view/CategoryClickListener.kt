package com.example.foodapp.view

import com.example.foodapp.model.data.CategoryData

interface CategoryClickListener {
    fun onClick(category: CategoryData)
}