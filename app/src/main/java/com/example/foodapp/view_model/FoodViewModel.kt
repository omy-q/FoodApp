package com.example.foodapp.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.FoodModel
import com.example.foodapp.model.FoodModelImplementation

class FoodViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val foodModel: FoodModel = FoodModelImplementation()
) : ViewModel() {

    fun getLiveData() = liveData
    fun init() {
        liveData.value =
            AppState.SuccessInitData(foodModel.getBanners(), foodModel.getFoodCategories())
    }

    fun getDataOfCategory() {
        val categories = foodModel.getFoodCategories()
        liveData.postValue(AppState.SuccessFoodOfCategory(foodModel.getFoodMenuOfCategory(categories[0])))
    }

}