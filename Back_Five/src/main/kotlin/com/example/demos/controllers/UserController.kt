package com.example.demos.controllers

import com.example.demos.error.Unauthentication
import com.example.demos.models.User
import com.example.demos.others.CheckLog
import com.example.demos.services.UserService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class UserController(@Autowired private val userService: UserService) {

    @Value("\${jwt.secret}")
    val secret: String? = null

    @GetMapping("users")
    fun findAll(@CookieValue jwt: String?): List<User?> {
        CheckLog().check(jwt)
        return this.userService.getAll()
    }

    @GetMapping("user/profile")
    fun findUserProfile(@CookieValue jwt: String?): ResponseEntity<User> {
        if (jwt == null) {
            throw Unauthentication("Token not found")
        }

        val secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))

        val body: Claims
        try {
            body = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(jwt).body
        }
        catch (e: Exception) {
            throw Unauthentication("Invalid token")
        }

        return ResponseEntity.ok(this.userService.findById(body.issuer.toLong()))
    }
    @GetMapping("user/{id}")
    fun findUserById(@PathVariable id: Long, @CookieValue jwt: String?): ResponseEntity<User> {
        CheckLog().check(jwt)
        return ResponseEntity.ok(this.userService.findById(id))
    }
}