package com.example.demos.controllers

import com.example.demos.models.Review
import com.example.demos.others.CheckLog
import com.example.demos.services.ReviewService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/review")
class ReviewController(@Autowired val reviewService: ReviewService) {

    @GetMapping("/all")
    fun getAllReview(@CookieValue jwt: String?): ResponseEntity<List<Review?>> {
        CheckLog().check(jwt)
         return ResponseEntity.ok().body(reviewService.getAll())
    }

    @GetMapping("/{id}")
    fun findReview(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<Review?> {
        CheckLog().check(jwt)
        return ResponseEntity.ok().body(this.reviewService.findById(id))
    }

    @PostMapping
    fun saveReview(@RequestBody body: Review, @CookieValue jwt: String?): ResponseEntity<Review> {
        CheckLog().check(jwt)
        val review = Review(null, body.body, body.rate, body.user)

        return ResponseEntity.ok().body(this.reviewService.save(review))
    }

    @DeleteMapping("/{id}")
    fun deleteReviewById(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<Any> {
        CheckLog().check(jwt)
        this.reviewService.deleteById(id)
        return ResponseEntity.ok("Success")
    }
}