package com.example.Back_Three.mock

import com.example.Back_Three.controllers.BankByAccountNumber
import com.example.Back_Three.datasource.BankDataSource
import com.example.Back_Three.model.Bank
import com.example.Back_Three.model.BankPatch
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    var banks = listOf(
        Bank("123", 3.14,1),
        Bank("132", 2.73,1),
        Bank("231", 0.67,1)
    )
    override fun retrieveBanks(): Collection<Bank> = banks

    override fun setBank(newBank: Bank): Bank  {
        banks = banks.plus(newBank)
        return newBank
    }

    override fun deleteBank(indexBank: Int): String {
        banks = banks.filterIndexed{ index, _ -> index != indexBank}
        return "OK"
    }

    override fun updateBank(newBanks: BankPatch, index: Int): Bank {
        banks[index].trust = newBanks.trust
        banks[index].transactionFee = newBanks.transactionFee

        return banks[index]
    }
}