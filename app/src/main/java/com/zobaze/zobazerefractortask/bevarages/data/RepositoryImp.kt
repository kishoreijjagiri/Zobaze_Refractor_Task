package com.zobaze.zobazerefractortask.bevarages.data

import com.zobaze.zobazerefractortask.bevarages.data.dto.BeersAleResponseItem
import com.zobaze.zobazerefractortask.bevarages.data.network.RetrofitApi
import com.zobaze.zobazerefractortask.bevarages.domain.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor (val retrofitApi: RetrofitApi) : Repository {
    override suspend fun getData(): List<BeersAleResponseItem> {
       return retrofitApi.getData()
    }


}