package com.jlopez.pokedex.repository

import com.jlopez.pokedex.data.remote.PokeApi
import com.jlopez.pokedex.data.remote.responses.Pokemon
import com.jlopez.pokedex.data.remote.responses.PokemonList
import com.jlopez.pokedex.util.Resource
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}