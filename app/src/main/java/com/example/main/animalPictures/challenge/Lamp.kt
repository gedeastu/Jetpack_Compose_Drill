package com.example.main.animalPictures.challenge

import androidx.annotation.DrawableRes

data class Lamp(
    val status: String,
    @DrawableRes val imageResId: Int,
    val desc: String
)