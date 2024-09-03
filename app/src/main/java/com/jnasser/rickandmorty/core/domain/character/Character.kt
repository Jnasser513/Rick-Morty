package com.jnasser.rickandmorty.core.domain.character

import kotlinx.serialization.Serializable

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String
)
