package com.gsesdras.retrofit.data.mapper

import com.gsesdras.retrofit.data.model.AccountDTO
import com.gsesdras.retrofit.model.Account
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun AccountDTO.toModel() = Account(
    id = id,
    name = name,
    username = username,
    avatarUrl = avatar,
    createdAt = getDate(createdAt)
)

private fun getDate(value: String) = Instant.parse(value).atZone(ZoneId.systemDefault())