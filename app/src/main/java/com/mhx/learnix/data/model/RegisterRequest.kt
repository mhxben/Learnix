package com.mhx.learnix.data.model

data class RegisterRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val role : String,
    val dateOfBirth :String
)
