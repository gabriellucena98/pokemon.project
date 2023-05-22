package backend.pokemon.project.repository

import backend.pokemon.project.domain.UserMaster
import backend.pokemon.project.repository.mapper.UserMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) {
    private val SELECT_USER_BY_LOGIN = """
        SELECT * FROM user_master
        WHERE email = :email 
        AND password = :password
    """.trimIndent()

    private val SELECT_USER_BY_EMAIL = """
        SELECT * FROM user_master
        WHERE email = :email
    """.trimIndent()

    private val SAVE_USER = """
        INSERT INTO user_master(username, email, password)
        VALUES (:username, :email, :password)
    """.trimIndent()

    fun getUserByLogin(email: String, password: String): UserMaster {
        return namedParameterJdbcTemplate.query(
            SELECT_USER_BY_LOGIN,
            mapOf("email" to email, "password" to password),
            UserMapper()).first()
    }

    fun validateUserId(userEmail: String): Boolean {
        return namedParameterJdbcTemplate.query(
            SELECT_USER_BY_EMAIL,
            mapOf("email" to userEmail),
            UserMapper()).isNotEmpty()
    }

    fun saveUser(username: String, email: String, password: String) {
        val params = mapOf(
            "username" to username,
            "email" to email,
            "password" to password
        )
        namedParameterJdbcTemplate.update(SAVE_USER, params)
    }
}