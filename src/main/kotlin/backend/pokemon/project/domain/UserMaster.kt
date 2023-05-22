package backend.pokemon.project.domain
data class UserMaster(
    val id: Long,
    val username: String,
    val email: String,
    val password: String,
    val image: String?
)

