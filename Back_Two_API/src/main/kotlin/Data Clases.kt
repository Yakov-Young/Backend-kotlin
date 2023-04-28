import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.*

data class Data(@field:Min(0)
                @field:Max(2)
                val page: Int,

                @field:Positive(message = "a")
                @field:JsonProperty("per_page")
                val perPage: Int,

                @field:Positive
                val total: Int,

                @field:Positive
                @field:JsonProperty("total_pages")
                val totalPages: Int,

                @field:NotEmpty
                val data: ArrayList<User>,

                @field:NotNull
                val support: Support)


data class User(@field:Positive
                val id: Int,

                @field:Email
                @field:NotNull
                val email: String,

                @field:NotNull
                @field:JsonProperty("first_name")
                val firstName: String,

                @field:NotNull
                @field:JsonProperty("last_name")
                val lastName: String,

                @field:NotNull
                val avatar: String)


data class Support(@field:NotNull
                   val url: String,

                   @field:NotNull
                   val text: String)