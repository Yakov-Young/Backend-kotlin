package com.example.demos.others

import com.example.demos.error.Unauthentication
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CheckLog() {
    private var secret: String = "qBTmv4oXFFR2GwjexDJ4t6fsIUIUhhXqlktXjXdkcyygs8nPVEwMfo29VDRRepYDVV5IkIxBMzr7OEHXEHd37w=="

    fun check(jwt: String?) {
        if (jwt == null) {
            throw Unauthentication("Token not found")
        }

        val secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))

        try {
            Jwts.parserBuilder().setSigningKey(secret).build()
        }
        catch (e: Exception) {
            throw Unauthentication("Invalid token")
        }
    }
}