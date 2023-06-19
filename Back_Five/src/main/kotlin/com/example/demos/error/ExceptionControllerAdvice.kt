package com.example.demos.error

import com.example.demos.dtos.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun responseErrorBankNotFound(exception: Unauthentication): ResponseEntity<Message> {
        val errorMessage = Message(
            exception.message
        )
        return ResponseEntity.status(401).body(errorMessage)
    }

}