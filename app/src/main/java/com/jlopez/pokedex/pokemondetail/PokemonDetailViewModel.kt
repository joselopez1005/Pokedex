package com.jlopez.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.jlopez.pokedex.data.remote.responses.Pokemon
import com.jlopez.pokedex.repository.PokemonRepository
import com.jlopez.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}