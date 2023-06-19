package com.example.demos.services

import com.example.demos.models.Author
import com.example.demos.repo.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun getAll(): List<Author> = this.authorRepository.findAll()
}