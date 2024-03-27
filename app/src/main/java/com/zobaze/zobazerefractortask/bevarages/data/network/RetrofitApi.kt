package com.zobaze.zobazerefractortask.bevarages.data.network

import com.zobaze.zobazerefractortask.bevarages.data.dto.BeersAleResponseItem
import retrofit2.http.GET

interface RetrofitApi {

    @GET("/beers/ale")
    suspend fun getData(): List<BeersAleResponseItem>
}