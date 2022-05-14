package com.gsesdras.navigation.extension

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.navigateSafe(directions: NavDirections) {
    runCatching {
        navigate(directions)
    }.onFailure {
        Log.d(context.applicationContext.packageName, it.message.toString())
    }
}