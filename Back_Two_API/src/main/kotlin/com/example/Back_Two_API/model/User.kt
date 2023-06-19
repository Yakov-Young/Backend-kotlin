package com.example.Back_Two_API.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class User(
    @field:Min(value = 1, message = "id must be greater than 0")
    val id: Int,

    @field:Email(message = "email must be a valid email address")
    val email: String,

    @NotBlank(message = "error")
    @field:JsonProperty("first_name")
    val firstName: String,

    @NotBlank(message = "error")
    @field:JsonProperty("last_name")
    val lastName: String,

    val avatar: String?
) {
    constructor() : this(1, "", "", "","")
}