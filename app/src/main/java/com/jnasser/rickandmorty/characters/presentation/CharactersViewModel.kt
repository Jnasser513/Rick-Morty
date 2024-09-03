package com.jnasser.rickandmorty.characters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnasser.rickandmorty.characters.domain.CharactersRepository
import com.jnasser.rickandmorty.core.domain.util.map
import kotlinx.coroutines.launch
import timber.log.Timber

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
): ViewModel() {

    init {
        viewModelScope.launch {
            val result = charactersRepository.getRemoteCharacters()
            Timber.d("New results detected: ${result.map { it.results.size }}")
        }
    }
}