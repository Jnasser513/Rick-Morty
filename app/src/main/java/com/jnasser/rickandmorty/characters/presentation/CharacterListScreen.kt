package com.jnasser.rickandmorty.characters.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreenRot(
    viewModel: CharactersViewModel = koinViewModel()
) {
//    CharacterListScreen(
//        state = viewModel.state,
//        onAction = viewModel::onAction
//    )
}

//@Composable
//private fun CharacterListScreen(
//    state: ,
//    onAction: () -> Unit
//) {
//
//}
//
//@Preview
//@Composable
//private fun CharacterListScreenPreview() {
//     {
//        CharacterListScreen(
//            state = (),
//            onAction = {}
//        )
//    }
//}