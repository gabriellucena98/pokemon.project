package backend.pokemon.project.controller.dto

import backend.pokemon.project.model.Results

data class GetAllRequestDto(
    val results: List<Results>
)