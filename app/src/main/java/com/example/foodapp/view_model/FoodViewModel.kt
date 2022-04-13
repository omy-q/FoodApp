package com.example.foodapp.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.FoodModel
import com.example.foodapp.model.FoodModelImplementation
import com.example.foodapp.model.RemoteDataSource
import com.example.foodapp.model.data.CategoryData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FoodViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val foodModel: FoodModel = FoodModelImplementation(RemoteDataSource.remoteSource)
) : ViewModel() {

    fun getLiveData() = liveData
    fun init() {
        foodModel.getFoodCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ categoriesData ->
                liveData.postValue(AppState.SuccessInitData(categoriesData.categories))
            }, { error ->
                liveData.postValue(AppState.Error(error))
            })
    }

    fun getDataOfCategory(category: CategoryData) {
        foodModel.getFoodMenuOfCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ food ->
                liveData.postValue(AppState.SuccessFoodOfCategory(food.foodData))
            }, {error ->
                liveData.postValue(AppState.Error(error))
            })
    }

}