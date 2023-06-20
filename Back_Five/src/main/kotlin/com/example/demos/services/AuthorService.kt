package com.example.demos.services

import com.example.demos.models.Author
import com.example.demos.repository.AuthorRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun getAll(): List<Author?> = this.authorRepository.findAll()
    fun findById(@NonNull id: Long): Author? = this.authorRepository.getById(id)

    fun save(@RequestBody author: Author) = this.authorRepository.save(author)
    fun deleteById(id: Long) = this.authorRepository.deleteById(id)

}