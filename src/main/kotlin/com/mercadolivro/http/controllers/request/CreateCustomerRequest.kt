package com.mercadolivro.http.controllers.request

data class CreateCustomerRequest(
    var name: String,
    var email: String
)