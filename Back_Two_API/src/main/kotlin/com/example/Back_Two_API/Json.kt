package com.example.Back_Two_API

import com.example.Back_Two_API.model.Data
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Json {

    companion object {
        private val objectMapper = jacksonObjectMapper()

        fun write(data: Data): String {
            try {
                return objectMapper.writeValueAsString(data)
            } catch (e: Exception) {
                throw RuntimeException(e.message)
            }
        }

        fun read(line: String): Data {
            try {
                return objectMapper.readValue<Data>(line)
            } catch (e: Exception) {
                throw RuntimeException(e.message)
            }
        }
    }
}