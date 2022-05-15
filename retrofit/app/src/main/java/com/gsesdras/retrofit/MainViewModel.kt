package com.gsesdras.retrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gsesdras.retrofit.business.GetAccountsUseCase
import com.gsesdras.retrofit.model.Account
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAccountsUseCase: GetAccountsUseCase
): ViewModel() {

    private val _accounts = MutableStateFlow<List<Account>>(emptyList())
    val accounts get() = _accounts.asStateFlow()

    fun getAccounts(){
        viewModelScope.launch {
            getAccountsUseCase().catch {
                Log.d(javaClass.name, it.message.toString())
            }.collect {
                _accounts.value = it
            }
        }
    }

}