package com.example.demos.controllers

import com.example.demos.dtos.LoginDTO
import com.example.demos.dtos.Message
import com.example.demos.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class LogController(@Autowired val userService: UserService) {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @PostMapping("/login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("User not found"))

        if (!user.comparePassword(body.password))
            return ResponseEntity.badRequest().body(Message("invalid password"))

        val issuer = user.id.toString()
        val key = Keys.hmacShaKeyFor(
            Decoders.BASE64.decode(secret)
        )

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() * 60 * 24 * 1000))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("Ok"))
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge=0

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("Success"))
    }
}