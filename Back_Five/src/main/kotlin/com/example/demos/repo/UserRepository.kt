package com.example.demos.repo

import com.example.demos.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun save(user: User): User
    fun findByEmail(email: String): User?
    override fun getById(id: Long): User
}