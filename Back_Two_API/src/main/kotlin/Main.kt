
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import javax.validation.Validation


fun main() {
    try {
        val url = "https://reqres.in/api/users?page=1"
        val api = API()
        val json = api.get(url)

        val mapper = ObjectMapper()

        val serialJson = mapper.readValue<Data>(json)
        println("Deserialized data: $serialJson")

        //val factory = Validation.buildDefaultValidatorFactory()
        //val validator = factory.validator

        val data = Data(
            1,
            3,
            6,
            2,
            data = listOf(
                User(1, "george.bluth@reqres.in", "George", "Bluth", null),
                User(2, "janet.weaver@reqres.in", "Janet", "Weaver", null),
                User(3, "emma.wong@reqres.in", "Emma", "Wong", null)
            ),
            support = Support(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!"
            )
        )


        /*val factory = Validation.buildDefaultValidatorFactory()
        val validator = factory.validator

        val violations = validator.validate(data)

        if (violations.isNotEmpty()) {
            for (violation in violations) {
                println(violation.message)
            }
        } else {
            val serializedData = mapper.writeValueAsString(data)
            print("\n\nDeserialized data: $serializedData")
        }
        */ // Не подкоючался валидатор, но ,вроде как, должно работать

            val serializedData = mapper.writeValueAsString(data)
            print("\n\nDeserialized data: $serializedData")

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

class API {
    private val client = OkHttpClient()

    fun get(url: String): String {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            return response.body!!.string()
        }
    }

}
