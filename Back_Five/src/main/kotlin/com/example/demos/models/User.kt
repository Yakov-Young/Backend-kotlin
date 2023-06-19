package com.example.demos.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Table(name = "user", schema = "books")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(unique = true)
    var email: String,

) {

    var password: String = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }

}


/*@Entity
@Table(name = "User")
class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "first_name")
    val firstName: String = "name"

    @Column(name = "last_name")
    val lastName = ""

    @Column(name = "email")
    val email = ""

    @Column(name = "password")
    val password = ""

}*/