package com.example.demos.services

import com.example.demos.models.Book
import com.example.demos.models.Review
import com.example.demos.repo.ReviewRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {
    fun getAll(): List<Review> = this.reviewRepository.findAll()
    fun findById(@NonNull id: Long): Review? = this.reviewRepository.getById(id)

    fun save(@RequestBody review: Review) = this.reviewRepository.save(review)
    fun deleteById(id: Long) = this.reviewRepository.deleteById(id)
}