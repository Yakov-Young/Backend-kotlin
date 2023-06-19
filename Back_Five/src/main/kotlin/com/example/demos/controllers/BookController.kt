package com.example.demos.controllers

import com.example.demos.models.Book
import com.example.demos.models.User
import com.example.demos.services.BookService
import com.example.demos.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book")
class BookController(@Autowired private val bookService: BookService) {

    @GetMapping("/all")
    fun findAllBooks(): ResponseEntity<List<Book?>> = ResponseEntity.ok().body(this.bookService.findAll())

    @GetMapping("/{id}")
    fun findBook(@PathVariable id: Long): ResponseEntity<Book> {
        return ResponseEntity.ok().body(this.bookService.findById(id))
    }
}