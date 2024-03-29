package com.mercadolivro.http.controllers.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UpdateCustomerRequest(
    @field:NotEmpty(message = "O nome deve ser informado")
    var name: String,

    @field:Email(message = "Email deve ester em formato valido!")
    var email: String
)