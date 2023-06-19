package com.example.Back_Two_API

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude= [DataSourceAutoConfiguration::class])
class BackTwoApiApplication

fun main(args: Array<String>) {
	runApplication<BackTwoApiApplication>(*args)
}
