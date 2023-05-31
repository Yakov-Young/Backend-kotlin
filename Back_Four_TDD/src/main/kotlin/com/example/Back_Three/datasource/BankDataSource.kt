package com.example.Back_Three.datasource

import com.example.Back_Three.controllers.BankByAccountNumber
import com.example.Back_Three.model.Bank
import com.example.Back_Three.model.BankPatch

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun setBank(newBank: Bank): Bank
    fun deleteBank(indexBank: Int): String
    fun updateBank(newBanks: BankPatch, index: Int): Bank
}