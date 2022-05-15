package com.gsesdras.retrofit.data.repository

import com.gsesdras.retrofit.data.AccountService
import com.gsesdras.retrofit.data.model.AccountDTO
import retrofit2.Response

class AccountRepositoryImpl(
    private val service: AccountService
) : AccountRepository {

    override suspend fun getAccounts(): Response<List<AccountDTO>> {
        return service.getAccounts()
    }

}