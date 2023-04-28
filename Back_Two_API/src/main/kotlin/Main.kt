import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.*
import java.io.IOException


fun main() {
    val url = "https://reqres.in/api/users?page=1"
    val api = API()
    val json = api.get(url)

    val mapper = jacksonObjectMapper()

    val data = Data(100,
        100,
        100,
        1000,
        arrayListOf(
            User(1,
                "dom@mail.ru",
                "Anton",
                "Pavlovich",
                "https://reqres.in/img/faces/1-image.jpg")
        ),
        Support("https://reqres.in/#support-heading",
            "To keep...")
    )

    val s = mapper.readValue<Data>(json)
    val r = mapper.writeValueAsString(data)
    println(s)
    print(r)
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

