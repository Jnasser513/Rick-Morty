package com.jnasser.rickandmorty.characters.data

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResultDto(
    val results: List<CharacterDto>
)
