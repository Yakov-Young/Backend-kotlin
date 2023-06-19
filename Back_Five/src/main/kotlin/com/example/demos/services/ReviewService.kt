package com.example.demos.services

import com.example.demos.models.Review
import com.example.demos.repo.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {
    fun getAll(): List<Review> = this.reviewRepository.findAll()
}