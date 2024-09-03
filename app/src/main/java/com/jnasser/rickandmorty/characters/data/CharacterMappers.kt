package com.jnasser.rickandmorty.characters.data

import com.jnasser.rickandmorty.core.domain.character.Character
import com.jnasser.rickandmorty.core.domain.character.CharacterResult

fun CharacterDto.toCharacter() = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender
)

fun CharacterResultDto.toCharacterResult() = CharacterResult(
    results = results.map { it.toCharacter() }
)