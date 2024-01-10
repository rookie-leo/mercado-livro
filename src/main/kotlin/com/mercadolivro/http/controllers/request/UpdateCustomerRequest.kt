package com.mercadolivro.http.controllers.request

data class UpdateCustomerRequest(
    var name: String,
    var email: String
)