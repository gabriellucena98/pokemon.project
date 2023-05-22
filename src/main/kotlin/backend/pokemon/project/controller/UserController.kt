package backend.pokemon.project.controller

import backend.pokemon.project.controller.dto.GenericResponseWithIdDto
import backend.pokemon.project.controller.dto.RegisterUserRequestDto
import backend.pokemon.project.domain.UserMaster
import backend.pokemon.project.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val service: UserService,
) {

    @GetMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    fun getUserByLogin(
        @RequestHeader email: String,
        @RequestHeader password: String,
    ): ResponseEntity<UserMaster>
    {
        return ResponseEntity.ok(service.getUserByLogin(email, password))
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun registerUser(
        @RequestBody userRequestDto: RegisterUserRequestDto
    ): ResponseEntity<GenericResponseWithIdDto> {
        val username = service.registerUser(userRequestDto)
        return ResponseEntity.ok(GenericResponseWithIdDto(username, "201", "Usuário Registrado!"))
    }
}