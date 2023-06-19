package com.example.demos.repo

import com.example.demos.models.Author
import com.example.demos.models.Book
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author, Long> {
}