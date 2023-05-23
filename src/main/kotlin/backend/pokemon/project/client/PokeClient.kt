package backend.pokemon.project.client

import backend.pokemon.project.controller.dto.GetAllRequestDto
import backend.pokemon.project.domain.Pokemon
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "PokeClient", url = "https://pokeapi.co/api/v2/")
interface PokeClient {

    @RequestMapping(method = [RequestMethod.GET], path = ["pokemon/{name}"])
    fun getPokemonByName(
        @PathVariable("name") name: String
    ): Pokemon?

    @RequestMapping(method = [RequestMethod.GET], path = ["pokemon?limit=151&offset=0"])
    fun getAllPokemon(): GetAllRequestDto

    @RequestMapping(method = [RequestMethod.GET], path = ["pokemon?limit={page}&offset={offSet}"])
    fun getAllPokemon(
        @PathVariable("page") page: Int?,
        @PathVariable("offSet") offSet: Long?
    ): GetAllRequestDto
}