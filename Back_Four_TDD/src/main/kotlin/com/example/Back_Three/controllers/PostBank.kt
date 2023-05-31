package com.example.Back_Three.controllers

import com.example.Back_Three.model.Bank
import com.example.Back_Three.service.BankService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/bank")
class PostBank(private val service: BankService) {

    @PostMapping
    fun getBank(@RequestBody newBank: Bank): Bank = service.postBank(newBank)
}
