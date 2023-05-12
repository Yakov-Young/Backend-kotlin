import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import com.fasterxml.jackson.annotation.*

interface ApiService {
    @GET("users?page=1")
    fun getUsers(): Call<UsersResponse>
}

data class UsersResponse(val data: List<User>)
data class User(@Min(1) val id: Int,
                val email: String,
                val first_name: String,
                val last_name: String,
                val avatar: String)


fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
    val call = apiService.getUsers()
    val response = call.execute()

    if (response.isSuccessful) {
        val usersResponse = response.body()
        println(usersResponse?.data)
    } else {
        println(response.errorBody()?.string())
    }
}