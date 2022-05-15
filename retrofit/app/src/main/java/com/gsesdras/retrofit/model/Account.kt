package com.gsesdras.retrofit.model

import java.time.ZonedDateTime

class Account(
    val id: String,
    val name: String,
    val username: String,
    val avatarUrl: String,
    val createdAt: ZonedDateTime
)