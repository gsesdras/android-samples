package com.gsesdras.retrofit.core

import android.app.Application
import com.gsesdras.retrofit.MainViewModel
import com.gsesdras.retrofit.business.GetAccountsUseCase
import com.gsesdras.retrofit.data.AccountService
import com.gsesdras.retrofit.data.repository.AccountRepository
import com.gsesdras.retrofit.data.repository.AccountRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitApplication : Application() {

    private val appModule by lazy {
        module {
            single<Retrofit> {
                Retrofit.Builder()
                    .baseUrl("https://6280626a7532b4920f6e68f5.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            factory<AccountService> {
                get<Retrofit>()
                    .create()
            }

            factory<AccountRepository> {
                AccountRepositoryImpl(
                    service = get()
                )
            }

            factory {
                GetAccountsUseCase(
                    accountRepository = get()
                )
            }

            viewModel {
                MainViewModel(
                    getAccountsUseCase = get()
                )
            }
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@RetrofitApplication)
            modules(appModule)
        }
    }

}