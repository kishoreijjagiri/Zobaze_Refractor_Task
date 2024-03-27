package com.zobaze.zobazerefractortask.bevarages.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zobaze.zobazerefractortask.bevarages.data.dto.BeersAleResponseItem
import com.zobaze.zobazerefractortask.common.Response
import com.zobaze.zobazerefractortask.bevarages.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BevaragesViewModel @Inject constructor(var repository: Repository) : ViewModel() {

    private val _data = MutableLiveData<Response<List<BeersAleResponseItem>>>()

    val data: LiveData<Response<List<BeersAleResponseItem>>>
        get() = _data

     fun getdata() {
         if(data.value == null) {
             viewModelScope.launch {
                 _data.value = Response.Loading()
                 var response = repository.getData()
                 Log.v("kishore", response.toString())
                 try {
                     _data.value = Response.Success(response)
                 } catch (e: Exception) {
                     _data.value = Response.Error("API failure ")
                 }

             }
         }
     }

    override fun onCleared() {
        super.onCleared()
        Log.v("kishore","view model onCleared")
    }
}