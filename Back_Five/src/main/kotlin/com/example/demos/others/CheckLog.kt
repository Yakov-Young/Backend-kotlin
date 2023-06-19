package com.example.demos.others

import com.example.demos.error.Unauthentication
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CheckLog {

    @Value("\${jwt.secret}")
    private var secret: String? = null

    fun check(jwt: String?): Jws<Claims> {
        if (jwt == null) {
            throw Unauthentication("Token not found")
        }

        val secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))

        val body: Jws<Claims>
        try {
            body = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(jwt)
        }
        catch (e: Exception) {
            throw Unauthentication("Invalid token")
        }
        return body
    }
}