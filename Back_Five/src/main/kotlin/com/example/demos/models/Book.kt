package com.example.demos.models

import jakarta.persistence.*

@Entity
@Table(name = "book", schema = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val description: String,

    @Column(name = "ISBN", nullable = false)
    val isbn: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_author", schema = "books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName="id")],
        inverseJoinColumns = [JoinColumn(name = "author_id", referencedColumnName="id")])
    var authors: Author,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_review", schema = "books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName="id")],
        inverseJoinColumns = [JoinColumn(name = "review_id", referencedColumnName="id")])
    val reviews: Set<Review>?

)