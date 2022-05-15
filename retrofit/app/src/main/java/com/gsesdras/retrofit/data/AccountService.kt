package com.gsesdras.retrofit.data

import com.gsesdras.retrofit.data.model.AccountDTO
import retrofit2.Response
import retrofit2.http.GET

interface AccountService {

    @GET("accounts")
    suspend fun getAccounts(): Response<List<AccountDTO>>
}