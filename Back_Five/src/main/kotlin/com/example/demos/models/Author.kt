package com.example.demos.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "author", schema = "books")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(name = "date_of_birth", nullable = true)
    val dateOfBirth: LocalDateTime?,

    @Column(name = "date_of_death", nullable = true)
    val dateOfDeath: LocalDateTime?,

    @Column(nullable = false)
    val country: String,

    /*@ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    var books: Set<Book>*/

)