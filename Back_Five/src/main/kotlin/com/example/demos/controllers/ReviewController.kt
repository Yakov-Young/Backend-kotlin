package com.example.demos.controllers

import com.example.demos.models.Review
import com.example.demos.services.ReviewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ReviewController(@Autowired val reviewService: ReviewService) {

    @GetMapping("/review")
    fun getAll(): List<Review?> = this.reviewService.getAll()
}