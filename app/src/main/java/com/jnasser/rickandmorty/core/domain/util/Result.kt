package com.jnasser.rickandmorty.core.domain.util

sealed interface Result<out D, out E: Error> {
    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Error<out E: com.jnasser.rickandmorty.core.domain.util.Error>(val error: E): Result<Nothing, E>
}

// Mapeo de data de tipo T a R
inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when(this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

// Mapear un resultado a vacio
fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {}
}

typealias EmptyResult<E> = Result<Unit, E>