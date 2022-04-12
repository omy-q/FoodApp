package com.example.foodapp.model.data

data class FoodData(
    val foodName: String,
    val foodDescription: String,
    val foodImage: String,
    val foodPrice: Int
)

val testFoodData = mutableListOf<FoodData>(
    FoodData("бестроганов", "hslgjrbgddfklgnfdkkgz", "0", 315),
    FoodData("jgncf", "zlgkdfnxkgehglilsdg", "1", 405),
    FoodData("fjzskdzsg", "zdjkfgjzoiesgdjzflgxdkjgjzdlxc", "2", 203),
    FoodData("fjdfkg dfkng", "jdkgjzoegdg z;righzvjxdf z;isgjlfxgh", "3", 15)
)