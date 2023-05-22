package backend.pokemon.project.controller.dto

data class RegisterUserRequestDto(
    val username: String,
    val email: String,
    val password: String,
)