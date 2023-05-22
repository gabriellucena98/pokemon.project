package backend.pokemon.project.controller

import backend.pokemon.project.controller.dto.GetAllRequestDto
import backend.pokemon.project.domain.Pokemon
import backend.pokemon.project.service.PokeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/poke")
class PokeController(
    private val service: PokeService
) {

    @GetMapping("/{name}")
    fun getPokemonByName(
        @PathVariable name: String
    ): ResponseEntity<Pokemon?> {
        return ResponseEntity.ok(service.getPokemonByName(name))
    }

    @GetMapping("/getAll")
    fun getAllPokemon(
        @RequestParam(required = false) page: Int?,
        @RequestParam(required = false) offSet: Long?
    ): ResponseEntity<GetAllRequestDto> {
        return ResponseEntity.ok(service.getAllPokemon(page, offSet))
    }


}