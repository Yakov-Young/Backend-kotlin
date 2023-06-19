package com.example.demos.controllers

import com.example.demos.models.Book
import com.example.demos.others.CheckLog
import com.example.demos.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book")
class BookController(@Autowired private val bookService: BookService) {

    @GetMapping("/all")
    fun findAllBooks(@CookieValue jwt: String?): ResponseEntity<List<Book?>> {
        CheckLog().check(jwt)
        return ResponseEntity.ok().body(this.bookService.findAll())
    }

    @GetMapping("/{id}")
    fun findBook(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<Book?> {
        CheckLog().check(jwt)
        return ResponseEntity.ok().body(this.bookService.findById(id))
    }

    @PostMapping
    fun saveBook(@RequestBody body: Book, @CookieValue jwt: String?): ResponseEntity<Book> {
        CheckLog().check(jwt)
        val book = Book(null, body.title, body.description, body.isbn, body.category, body.authors, null)

        return ResponseEntity.ok().body(this.bookService.save(book))
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<Any> {
        CheckLog().check(jwt)

        this.bookService.deleteById(id)
        return ResponseEntity.ok("Success")
    }

}