package com.example.demos.models

import jakarta.persistence.*

@Entity
@Table(name = "category", schema = "books")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "category_name", nullable = false)
    val categoryName: String
)