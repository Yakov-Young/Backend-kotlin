package com.example.demos.repo

import com.example.demos.models.Book
import com.example.demos.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BookRepository: JpaRepository<Book, Long> {
    override fun getById(id: Long): Book
}