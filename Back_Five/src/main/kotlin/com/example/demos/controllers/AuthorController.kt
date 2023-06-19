package com.example.demos.controllers

import com.example.demos.models.Author
import com.example.demos.services.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthorController(@Autowired val authorService: AuthorService) {
    @GetMapping("/author")
    fun getAll(): List<Author?> = this.authorService.getAll()
}