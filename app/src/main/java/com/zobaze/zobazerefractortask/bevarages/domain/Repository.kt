package com.zobaze.zobazerefractortask.bevarages.domain

import com.zobaze.zobazerefractortask.bevarages.data.dto.BeersAleResponseItem

interface Repository {

   suspend fun getData() : List<BeersAleResponseItem>
}