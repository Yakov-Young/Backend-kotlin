package com.example.Back_Three.controllers

import com.example.Back_Three.model.Bank
import com.example.Back_Three.model.BankPatch
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import com.google.gson.Gson
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class BankByAccountNumberTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    val gson = Gson()

    @Test
    fun `should return current bank`() {
        // when/then
        mockMvc.get("/api/bank/132")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }

    @Test
    fun `should delete current bank`() {
        // when/then
        mockMvc.delete("/api/bank/123")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }

    @Test
    fun `should patch current bank`() {
        // when/then
        val bank = BankPatch(3.14, 1)

        mockMvc.perform(
            MockMvcRequestBuilders.patch("/api/bank/132")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(bank)))
            .andExpect(status().isOk)
    }

}