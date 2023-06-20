package com.example.demos.repository

import com.example.demos.models.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
    override fun getById(id: Long): Review
}