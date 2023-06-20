package com.example.demos.repository

import com.example.demos.models.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Long> {
    override fun getById(id: Long): Book


    fun getByCategoryId(category: Long): List<Book>?
}