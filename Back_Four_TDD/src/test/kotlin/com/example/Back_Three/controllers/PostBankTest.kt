package com.example.Back_Three.controllers

import com.example.Back_Three.model.Bank
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class PostBankTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val gson = Gson()

    @Test
    fun `should post bank`() {
        // when/then

        val bank = Bank("1234", 3.14, 1)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/bank")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(bank)))
            .andExpect(MockMvcResultMatchers.status().isOk)

    }
}