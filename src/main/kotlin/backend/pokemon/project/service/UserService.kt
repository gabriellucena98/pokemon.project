package backend.pokemon.project.service

import backend.pokemon.project.controller.dto.RegisterUserRequestDto
import backend.pokemon.project.domain.UserMaster
import backend.pokemon.project.exception.AlreadyExistsException
import backend.pokemon.project.exception.error.UserError
import backend.pokemon.project.repository.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository

) {
    fun getUserByLogin(email: String, password: String): UserMaster {
        return userRepository.getUserByLogin(email, password)
    }

    fun registerUser(userRequestDto: RegisterUserRequestDto): String {
        val userEmail = userRequestDto.email
        if (validateUserId(userEmail)) {
            throw AlreadyExistsException(
                message = UserError.USER_ALREADY_EXISTS.message,
                email = userEmail,
                code = UserError.USER_ALREADY_EXISTS.code
            )
        }

        return try {
            userRepository.saveUser(
                userRequestDto.username,
                userRequestDto.email,
                userRequestDto.password
            )
            userEmail
        } catch (e: Exception) {
            e.message.toString()
        }
    }

    private fun validateUserId(userEmail: String): Boolean {
        return userRepository.validateUserId(userEmail)
    }
}