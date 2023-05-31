package com.example.Back_Three.service

import com.example.Back_Three.datasource.BankDataSource
import com.example.Back_Three.error.BankNotFound
import com.example.Back_Three.error.ObjectAlreadyExists
import com.example.Back_Three.model.Bank
import com.example.Back_Three.model.BankPatch
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource){
    fun getBanks(): Collection<Bank> {
        val banks = dataSource.retrieveBanks()

        if (banks.isNotEmpty()) {
            return banks
        }
        else {
            throw  BankNotFound("Objects not found")
        }
    }

    fun getBankByAccountNumber(@NotNull accountNumber: String): Bank =
        dataSource.retrieveBanks().firstOrNull { b -> b.accountNumber == accountNumber }
            ?: throw BankNotFound("Object not found")


    fun deleteBankByAccountNumber(@NotNull accountNumber: String): String {
        for ((index, value) in dataSource.retrieveBanks().withIndex()) {

            if (value.accountNumber == accountNumber) {
                return dataSource.deleteBank(index)
            }
        }

        throw BankNotFound("Object not found")
    }

    fun postBank(@NotNull newBank: Bank): Bank {
        val banks = dataSource.retrieveBanks()

        if (!banks.any { b -> b.accountNumber == newBank.accountNumber }) {
            return dataSource.setBank(newBank)
        }
        else {
            throw ObjectAlreadyExists("An object with the same accountNumber already exists")
        }
    }

    fun patchBank(@NotNull accountNumber: String, newBank: BankPatch): Bank {
        val banks = dataSource.retrieveBanks()

        if (banks.any { b -> b.accountNumber == accountNumber }) {
            val index = dataSource.retrieveBanks().indexOfFirst { it.accountNumber == accountNumber }

            return dataSource.updateBank(newBank, index)
        }
        else {
            throw ObjectAlreadyExists("Object not found")
        }
    }
}