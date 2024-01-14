package com.mercadolivro.http.controllers.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CreateCustomerRequest(
    @field:NotEmpty
    var name: String,

    @field:Email
    var email: String
)