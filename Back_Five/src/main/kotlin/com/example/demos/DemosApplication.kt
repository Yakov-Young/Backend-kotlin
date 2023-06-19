package com.example.demos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class DemosApplication

fun main(args: Array<String>) {
	runApplication<DemosApplication>(*args)
}
