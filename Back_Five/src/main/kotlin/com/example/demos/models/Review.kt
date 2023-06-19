package com.example.demos.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "review", schema = "books")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = true)
    var body: String?,

    @Column(nullable = false)
    var rate: Short,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User

) {
    @Column(name = "date_review", nullable = false)
    var dateReview: LocalDateTime = LocalDateTime.now()
        set(value) {
            field = LocalDateTime.now()
        }
}