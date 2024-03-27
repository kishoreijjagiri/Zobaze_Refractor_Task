package com.zobaze.zobazerefractortask.bevarages.data.dto

data class BeersAleResponseItem(
    val id: Int,
    val image: String,
    val name: String,
    val price: String,
    val rating: Rating
)