package com.gsesdras.retrofit.data.repository

import com.gsesdras.retrofit.data.model.AccountDTO
import retrofit2.Response

interface AccountRepository {
    suspend fun getAccounts(): Response<List<AccountDTO>>
}