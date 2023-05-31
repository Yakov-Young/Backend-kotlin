package com.example.Back_Three.service

import com.example.Back_Three.datasource.BankDataSource
import com.example.Back_Three.model.Bank
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BankServiceTest{

    private val dataSource: BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {

        //when
        val banks = bankService.getBanks()

        //then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }

    @Test
    fun `should call its data source to setBank banks`() {
        //given
        val bank = Bank("1234", 3.14, 1)

        //when
        val banks = bankService.postBank(bank)

        //then
        verify(exactly = 1) { dataSource.retrieveBanks() }
        verify(exactly = 1) { dataSource.setBank(bank) }
    }
}