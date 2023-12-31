package com.example.newsapp.domain.util

sealed class Resource<T>(var data :T ? =null, var message : String ? = null ){
    class Success<T>(data : T) : Resource<T>(data)
    class Error<T>( message: String ,data : T ?= null) : Resource<T>(data, message)
    class isLoading<T> : Resource<T>()
}
