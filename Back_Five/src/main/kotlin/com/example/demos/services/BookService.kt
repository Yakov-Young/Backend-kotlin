package com.example.demos.services

import com.example.demos.models.Book
import com.example.demos.models.User
import com.example.demos.repo.BookRepository
import com.example.demos.repo.UserRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findAll():List<Book?> = this.bookRepository.findAll().toList()

    fun findById(@NonNull id: Long): Book = this.bookRepository.getById(id)
}