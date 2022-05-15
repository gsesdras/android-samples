package com.gsesdras.retrofit.business

import com.gsesdras.retrofit.data.mapper.toModel
import com.gsesdras.retrofit.data.repository.AccountRepository
import kotlinx.coroutines.flow.flow

class GetAccountsUseCase(
    private val accountRepository: AccountRepository
) {

    operator fun invoke() = flow {
        accountRepository.getAccounts().run {
            if (isSuccessful) body()?.run {
                emit(map { it.toModel() })
            } ?: error("Response is null")
            else error(Exception())
        }
    }

}