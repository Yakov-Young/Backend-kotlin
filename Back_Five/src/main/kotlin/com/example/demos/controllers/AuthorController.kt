package com.example.demos.controllers

import com.example.demos.models.Author
import com.example.demos.others.CheckLog
import com.example.demos.services.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/author")
class AuthorController(@Autowired val authorService: AuthorService) {
    @GetMapping("/all")
    fun getAll(@CookieValue jwt: String?): List<Author?> {
        CheckLog().check(jwt)
        return this.authorService.getAll()
    }
    @GetMapping("/{id}")
    fun findAuthorById(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<Author?> {
        CheckLog().check(jwt)
        return ResponseEntity.ok().body(this.authorService.findById(id))
    }

    @PostMapping
    fun saveAuthor(@RequestBody body: Author, @CookieValue jwt: String?): ResponseEntity<Author> {
        CheckLog().check(jwt)
        val author = Author(null, body.name, body.dateOfBirth, body.dateOfDeath, body.country, null)

        return ResponseEntity.ok().body(this.authorService.save(author))
    }

    @DeleteMapping("/{id}")
    fun deleteAuthorById(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<String> {
        CheckLog().check(jwt)
        this.authorService.deleteById(id)
        return ResponseEntity.ok("Success")
    }
}