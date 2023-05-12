import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.*
import javax.validation.Valid

data class Data(
    @field:Min(value = 1, message = "page must be greater than 0")
    var page: Int,

    @field:Min(value = 1, message = "per_page must be greater than 0")
    @field:JsonProperty("per_page")
    val perPage: Int,

    @field:Min(value = 1, message = "total must be greater than or equal to 0")
    val total: Int,

    @field:Min(value = 1, message = "total_pages must be greater than 0")
    @field:JsonProperty("total_pages")
    val totalPages: Int,

    @field:NotEmpty(message = "data cannot be empty")
    @field:Valid
    val data: List<@Valid User>,

    @field:NotNull(message = "support cannot be null")
    @field:Valid
    val support: Support
) {
    constructor() : this(0, 0, 0, 0, emptyList(), Support("", ""))
}

data class User(
    @field:Min(value = 1, message = "id must be greater than 0")
    val id: Int,

    @field:Email(message = "email must be a valid email address")
    val email: String,

    @field:NotBlank(message = "first_name cannot be blank")
    @field:JsonProperty("first_name")
    val firstName: String,

    @field:NotBlank(message = "last_name cannot be blank")
    @field:JsonProperty("last_name")
    val lastName: String,

    val avatar: String?
) {
    constructor() : this(1, "", "", "","")
}

data class Support(
    val url: String,
    val text: String
) {
    constructor() : this("", "")
}