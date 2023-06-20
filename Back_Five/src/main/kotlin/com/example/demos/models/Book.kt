package com.example.demos.models

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIncludeProperties
import jakarta.persistence.*

@Entity
@Table(name = "book", schema = "books")
//@NamedQuery(name="Book.getByCategory", query="SELECT t1.id FROM books.book t1 WHERE t1.category_id = ?1")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var description: String,

    @Column(name = "ISBN", nullable = false)
    var isbn: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIncludeProperties(value=["categoryName"])
    @JoinColumn(name = "category_id", nullable = false)
    var category: Category,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_author", schema = "books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName="id")],
        inverseJoinColumns = [JoinColumn(name = "author_id", referencedColumnName="id")])
    @JsonIncludeProperties(value=["name"])
    var author: Author,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_review", schema = "books",
        joinColumns = [JoinColumn(name = "book_id", referencedColumnName="id")],
        inverseJoinColumns = [JoinColumn(name = "review_id", referencedColumnName="id")])
    @JsonIncludeProperties(value=["user", "rate"])
    val reviews: Set<Review>?

)