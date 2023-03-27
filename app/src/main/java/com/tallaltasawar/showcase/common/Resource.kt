package com.tallaltasawar.showcase.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Failure<T>(message: String?, error: T? = null) : Resource<T>(error, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}