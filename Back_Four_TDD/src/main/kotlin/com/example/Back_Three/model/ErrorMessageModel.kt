package com.example.Back_Three.model

import org.springframework.http.HttpStatus

class ErrorMessageModel(
    var status: HttpStatus? = null,
    var message: String? = null
)