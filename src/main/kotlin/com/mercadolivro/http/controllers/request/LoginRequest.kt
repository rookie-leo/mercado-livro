package com.mercadolivro.http.controllers.request

data class LoginRequest(
    val email: String,
    val password: String
)