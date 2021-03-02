package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    val name: String,
    val age: Int,
    val description: String,
    @DrawableRes val thumbnailId: Int
)