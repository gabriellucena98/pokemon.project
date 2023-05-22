package backend.pokemon.project.domain

data class Pokemon(
    val id: Long,
    val order: Long,
    val name: String,
    val types: List<Types>,
    val moves: List<Moves>,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)







