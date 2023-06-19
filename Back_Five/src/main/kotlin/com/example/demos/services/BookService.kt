package com.example.demos.services

import com.example.demos.models.Author
import com.example.demos.models.Book
import com.example.demos.models.User
import com.example.demos.repo.BookRepository
import com.example.demos.repo.UserRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class BookService(private val bookRepository: BookRepository) {
    fun findAll():List<Book?> = this.bookRepository.findAll().toList()

    fun findById(@NonNull id: Long): Book? = this.bookRepository.getById(id)

    fun save(@RequestBody book: Book) = this.bookRepository.save(book)
    fun deleteById(id: Long) = this.bookRepository.deleteById(id)
}
