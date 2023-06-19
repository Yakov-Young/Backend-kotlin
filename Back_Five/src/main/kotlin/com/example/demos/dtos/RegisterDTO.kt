package com.example.demos.dtos

import jakarta.persistence.Column

data class RegisterDTO (
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    )