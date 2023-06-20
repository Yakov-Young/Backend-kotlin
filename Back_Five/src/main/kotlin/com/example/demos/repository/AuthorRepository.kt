package com.example.demos.repository

import com.example.demos.models.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author, Long> {
    override fun getById(id: Long): Author

}