package backend.pokemon.project.exception

open class AlreadyExistsException(message: String, email: String, code: String) : RuntimeException("$message: $email") {
}