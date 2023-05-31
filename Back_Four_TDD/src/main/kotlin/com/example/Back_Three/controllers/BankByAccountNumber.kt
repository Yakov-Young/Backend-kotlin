package com.example.Back_Three.controllers

import com.example.Back_Three.model.Bank
import com.example.Back_Three.model.BankPatch
import com.example.Back_Three.model.ErrorMessageModel
import com.example.Back_Three.service.BankService
import org.apache.logging.log4j.message.Message
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/bank/{accountNumber}")
class BankByAccountNumber(private val service: BankService) {

    @GetMapping
    fun getBank(@PathVariable("accountNumber") accountNumber: String): Bank =
        service.getBankByAccountNumber(accountNumber)

    @DeleteMapping
    fun deleteBank(@PathVariable("accountNumber") accountNumber: String): String =
        service.deleteBankByAccountNumber(accountNumber)

    @PatchMapping
    fun patchBank(@PathVariable("accountNumber") accountNumber: String, @RequestBody newBank: BankPatch) =
        service.patchBank(accountNumber, newBank)
}