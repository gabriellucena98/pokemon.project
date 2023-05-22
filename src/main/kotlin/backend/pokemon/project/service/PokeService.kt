package backend.pokemon.project.service

import backend.pokemon.project.client.PokeClient
import backend.pokemon.project.controller.dto.GetAllRequestDto
import backend.pokemon.project.domain.Pokemon
import backend.pokemon.project.repository.PokeRepository
import org.springframework.stereotype.Service

@Service
class PokeService(
    private val repository: PokeRepository,
    private val client: PokeClient
) {
    fun getPokemonByName(name: String): Pokemon? {
        return client.getPokemonByName(name)
    }

    fun getAllPokemon(page: Int?, offSet: Long?): GetAllRequestDto {
        return if (page == null)
            return client.getAllPokemon()
        else
            client.getAllPokemon(page, offSet ?: 0L)
    }


}