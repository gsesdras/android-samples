package com.gsesdras.navigation.extension

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Before
import org.junit.Test

internal class NavigationExtKtTest {

    private lateinit var navController: NavController

    @Before
    fun setup(){
        navController = mockk(relaxed = true)
        mockkStatic(Log::class)

        every { navController.navigate(any<NavDirections>()) } just Runs
    }

    @Test
    fun navigateSafe() {
        navController.navigateSafe(mockk(relaxed = true))

        verify(exactly = 1) {
            navController.navigate(any<NavDirections>())
        }
        verify(exactly = 0) {
            Log.d(any(), any())
        }
    }

    @Test
    fun `navigateSafe, should log the throwable when navigation fails`(){
        every { navController.navigate(any<NavDirections>()) } throws Exception()
        every { Log.d(any(), any()) } returns 0

        navController.navigateSafe(mockk(relaxed = true))

        verify(exactly = 1) {
            Log.d(any(), any())
        }
    }
}