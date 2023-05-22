package backend.pokemon.project.exception.error

enum class UserError(
    val message: String,
    val code: String
) {
    USER_ALREADY_EXISTS(message = "That email already exists in the database: ", code = "error.conflict.user-already-exists"),
    USER_NOT_FOUND(message = "That email or password is wrong ", code = "error.not-found.user-not-exist"),
}