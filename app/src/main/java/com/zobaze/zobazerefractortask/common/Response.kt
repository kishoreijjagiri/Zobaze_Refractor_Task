package com.zobaze.zobazerefractortask.common


sealed class Response<T>(val data:T?=null, val message :String? =null) {
    class Loading<T> : Response<T>()
     class Success<T>( data: T): Response<T>(data)
    class Error<T>(message: String?, data: T? = null) : Response<T>(data, message)
}
