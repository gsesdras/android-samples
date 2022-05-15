package com.gsesdras.retrofit.extension

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun ZonedDateTime.toReadableDate(): String {
    return format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy"))
}