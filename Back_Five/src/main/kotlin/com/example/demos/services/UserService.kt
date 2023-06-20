package com.example.demos.services

import com.example.demos.models.User
import com.example.demos.repository.UserRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAll(): List<User?> = this.userRepository.findAll().toList()

    fun save(@NonNull user: User): User = this.userRepository.save(user)

    fun findByEmail(@NonNull email: String): User? = this.userRepository.findByEmail(email)

    fun findById(@NonNull id: Long): User = this.userRepository.getById(id)

}