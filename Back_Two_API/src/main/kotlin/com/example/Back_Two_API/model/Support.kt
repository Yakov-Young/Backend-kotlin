package com.example.Back_Two_API.model

import jakarta.persistence.Entity
import jakarta.validation.constraints.NotBlank

@Entity
data class Support(
    @NotBlank(message="Support.url cannot be null")
    var url: String,
    @NotBlank(message="Support.text cannot be null")
    var text: String
) {
    constructor() : this("", "")
}