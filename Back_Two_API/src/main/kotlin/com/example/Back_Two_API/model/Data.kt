package com.example.Back_Two_API.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@Entity
data class Data(
    @field:Min(value = 1, message = "Data.page must be greater than 0")
    var page: Int,

    @field:Min(value = 1, message = "Data.per_page must be greater than 0")
    @field:JsonProperty("per_page")
    var perPage: Int,

    @field:Min(value = 1, message = "Data.total must be greater than or equal to 0")
    var total: Int,

    @field:Min(value = 1, message = "Data.total_pages must be greater than 0")
    @field:JsonProperty("total_pages")
    var totalPages: Int,

    @field:NotEmpty(message = "Data.data cannot be empty")
    var data: List<User>,

    @field:NotNull(message="Data.support cannot be null")
    var support: Support
)