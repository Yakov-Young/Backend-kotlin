package com.example.Back_Two_API.controller

import com.example.Back_Two_API.Json
import com.example.Back_Two_API.model.Data
import com.example.Back_Two_API.model.Support
import com.example.Back_Two_API.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/api")
class Controller {

    @GetMapping
    fun get(): ResponseEntity<Data> {
        val restTemplate = RestTemplate()
        val url = "https://reqres.in/api/users?page=1"

        val line = restTemplate.getForObject(url, String::class.java)



        return ResponseEntity.ok().body(Json.read(line!!))
    }

    @PostMapping
    fun set(): ResponseEntity<Data> {
        val data = Data(
            1,
            3,
            6,
            2,
            data = listOf(
                User(1, "george.bluth@reqres.in", "George", "Blush", null),
                User(2, "janet.weaver@reqres.in", "Janet", "Weaver", null),
                User(3, "emma.wong@reqres.in", "Emma", "Wong", null)
            ),
            support = Support(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!"
            )
        )

        val json = Json.write(data)

        return ResponseEntity.ok().body(Json.read(json))
    }
}