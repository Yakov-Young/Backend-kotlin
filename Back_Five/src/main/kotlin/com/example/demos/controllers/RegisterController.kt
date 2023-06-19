package com.example.demos.controllers

import com.example.demos.dtos.RegisterDTO
import com.example.demos.models.User
import com.example.demos.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class RegisterController(@Autowired private val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User(
            id = null,
            firstName = body.firstName,
            lastName = body.lastName,
            email = body.email
        )

        user.password = body.password

        return ResponseEntity.ok(userService.save(user))
    }
}