package com.example.demos.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonIncludeProperties
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "author", schema = "books")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false)
    var name: String,

    @Column(name = "date_of_birth", nullable = true)
    var dateOfBirth: LocalDateTime?,

    @Column(name = "date_of_death", nullable = true)
    var dateOfDeath: LocalDateTime?,

    @Column(nullable = false)
    var country: String,

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIncludeProperties(value= ["title", "isbn"])
    @JoinTable(
        name = "book_review", schema = "books",
        joinColumns = [JoinColumn(name = "review_id", referencedColumnName="id")],
        inverseJoinColumns = [JoinColumn(name = "book_id", referencedColumnName="id")])
    var books: Set<Book>?

)