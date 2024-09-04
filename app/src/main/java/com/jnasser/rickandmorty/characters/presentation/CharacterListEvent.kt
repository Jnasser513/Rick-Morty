package com.jnasser.rickandmorty.characters.presentation

import com.jnasser.rickandmorty.core.presentation.ui.UiText

sealed interface CharacterListEvent {
    data class Error(val error: UiText): CharacterListEvent
}